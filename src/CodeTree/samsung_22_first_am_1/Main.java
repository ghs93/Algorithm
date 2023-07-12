package CodeTree.samsung_22_first_am_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * CodeTree. 술래잡기
 * @author hoseong
 * @category Simulation
 */
public class Main {
    static class Man {
        int r, c, d;

        Man(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static int N, M, H, K;
    static Man sul;
    static ArrayList<Man> runner;
    static boolean[][] tree;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int step, move, len;
    static boolean isReverse;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 격자 크기
        M = Integer.parseInt(st.nextToken()); // 도망자 수
        H = Integer.parseInt(st.nextToken()); // 나무 수
        K = Integer.parseInt(st.nextToken()); // 반복 수

        sul = new Man((N + 1) / 2, (N + 1) / 2, 0);
        runner = new ArrayList<>();
        tree = new boolean[N+1][N+1];

        step = 0;
        move = 0;
        len = 1;
        isReverse = false;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            runner.add(new Man(x, y, d));
        }

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x][y] = true;
        }

        for (int i = 1; i <= K; i++) {
            moveRunner();
            moveSul();

            findRunner(i);
        }

        System.out.println(result);
    }

    private static void moveRunner() {
        for (Man man : runner) {
            // 술래와 거리가 3이하인 경우에만 움직임
            if (Math.abs(man.r - sul.r) + Math.abs(man.c - sul.c) <= 3) {
                int dr = man.r + dir[man.d][0];
                int dc = man.c + dir[man.d][1];

                // 격자를 벗어나는 경우 방향 전환
                if (dr <= 0 || dr > N || dc <= 0 || dc > N) {
                    man.d = (man.d + 2) % 4;
                    dr = man.r + dir[man.d][0];
                    dc = man.c + dir[man.d][1];
                }

                // 이동하려는 칸에 술래가 있으면 이동 x
                if (sul.r == dr && sul.c == dc) continue;

                man.r = dr;
                man.c = dc;
            }
        }
    }

    private static void moveSul() {
        int dr = sul.r + dir[sul.d][0];
        int dc = sul.c + dir[sul.d][1];
        step++;

        if (step == len) {
            step = 0;
            move++;

            if (!isReverse)
                sul.d = (sul.d + 1) % 4;
            else
                sul.d = (sul.d + 3) % 4;

            if (move == 2) {
                move = 0;

                if (!isReverse) len++;
                else len--;
            }
        }

        if (dr == 1 && dc == 1) {
            isReverse = true;
            sul.d = 2;
            len = N-1;
            step = 0;
            move = -1;

        } else if (dr == (N + 1) / 2 && dc == (N + 1) / 2) {
            isReverse = false;
            sul.d = 0;
            len = 1;
            step = 0;
            move = 0;
        }

        sul.r = dr;
        sul.c = dc;
    }

    private static void findRunner(int turn) {
        int r = sul.r;
        int c = sul.c;
        int d = sul.d;

        int cnt = 0;
        for (int i = runner.size() - 1; i >= 0; i--) {
            Man run = runner.get(i);

            for (int j = 0; j < 3; j++) {
                int dr = r + dir[d][0] * j;
                int dc = c + dir[d][1] * j;

                if (run.r == dr && run.c == dc) {
                    if (tree[dr][dc]) continue;

                    cnt++;
                    runner.remove(i);
                    break;
                }
            }
        }

        result += turn * cnt;
    }
}
