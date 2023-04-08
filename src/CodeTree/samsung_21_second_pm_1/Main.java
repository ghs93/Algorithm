package CodeTree.samsung_21_second_pm_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * CodeTree. 팩맨
 * @author hoseong
 * @category Simulation
 */
public class Main {
    static class Monster {
        int r, c, d;

        Monster(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    static int N, M, T;
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int[][] monDir = {{}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    static int[] pack;
    static ArrayList<Monster>[][] monsters;
    static ArrayList<Integer>[][] egg;
    static ArrayList<Integer>[][] dead;
    static int[][] path = new int[3][2];
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = 4;
        M = Integer.parseInt(st.nextToken()); // 몬스터 수
        T = Integer.parseInt(st.nextToken()); // 턴 수

        pack = new int[2];
        monsters = new ArrayList[N+1][N+1];
        egg = new ArrayList[N+1][N+1];
        dead = new ArrayList[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        pack[0] = Integer.parseInt(st.nextToken());
        pack[1] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                monsters[i][j] = new ArrayList<>();
                egg[i][j] = new ArrayList<>();
                dead[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            monsters[r][c].add(new Monster(r, c, d));
        }

        for (int i = 0; i < T; i++) {
            makeEgg();
            moveMonster();
            movePack();
            clearDead();
            copyMonster();
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += monsters[i][j].size();
            }
        }

        System.out.println(result);
    }

    private static void makeEgg() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (monsters[i][j].size() > 0) {
                    for (int k = 0; k < monsters[i][j].size(); k++) {
                        egg[i][j].add(monsters[i][j].get(k).d);
                    }
                }
            }
        }
    }

    private static void moveMonster() {
        ArrayList<Monster> tmp = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (monsters[i][j].size() > 0) {
                    for (int k = monsters[i][j].size() - 1; k >= 0 ; k--) {
                        Monster monster = monsters[i][j].remove(k);

                        for (int l = monster.d; l <= monster.d + 8; l++) {
                            int d = l % 9;

                            if (d == 0) continue;

                            int dr = monster.r + monDir[d][0];
                            int dc = monster.c + monDir[d][1];

                            if (dr < 1 || dr > N || dc < 1 || dc > N) continue;
                            if (pack[0] == dr && pack[1] == dc) continue;
                            if (dead[dr][dc].size() > 0) continue;
                            monster.r = dr;
                            monster.c = dc;
                            monster.d = d;
                            break;
                        }

                        tmp.add(monster);
                    }
                }
            }
        }

        for (Monster monster : tmp) {
            monsters[monster.r][monster.c].add(monster);
        }
    }

    private static void movePack() {
        count = 0;
        boolean[][] visited = new boolean[N+1][N+1];
        dfs(pack[0], pack[1], new int[3][2], 0, 0, visited);

        pack[0] = path[2][0];
        pack[1] = path[2][1];
        for (int i = 0; i < 3; i++) {
            int r = path[i][0];
            int c = path[i][1];

            for (int j = 0; j < monsters[r][c].size(); j++) {
                dead[r][c].add(2);
            }

            monsters[r][c].clear();
        }
    }

    private static void dfs(int r, int c, int[][] p, int move, int cnt, boolean[][] visited) {
        if (move == 3) {
            if (cnt > count) {
                count = cnt;
                for (int i = 0; i < 3; i++) {
                    path[i][0] = p[i][0];
                    path[i][1] = p[i][1];
                }
            }
            return;
        }

        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int dr = r + dir[d][0];
            int dc = c + dir[d][1];

            if (dr < 1 || dr > N || dc < 1 || dc > N || visited[dr][dc]) continue;
            p[move][0] = dr;
            p[move][1] = dc;
            dfs(dr, dc, p, move+1, cnt + monsters[dr][dc].size(), visited);
        }
        visited[r][c] = false;
    }

    private static void clearDead() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dead[i][j].size() > 0) {
                    for (int k = dead[i][j].size() - 1; k >= 0; k--) {
                        int deadCnt = dead[i][j].get(k);

                        if (deadCnt == 0) {
                            dead[i][j].remove(k);

                        } else {
                            dead[i][j].set(k, deadCnt - 1);
                        }
                    }
                }
            }
        }
    }

    private static void copyMonster() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (egg[i][j].size() > 0) {
                    for (int k = egg[i][j].size() - 1; k >= 0; k--) {
                        monsters[i][j].add(new Monster(i, j, egg[i][j].remove(k)));
                    }
                }
            }
        }
    }
}
