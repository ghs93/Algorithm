package CodeTree.samsung_22_first_pm_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * CodeTree. 꼬리잡기놀이
 * @author hoseong
 * @category Simulation, BFS
 */
public class Main {
    static class Team {
        int r, c;

        Team(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, K;
    static int[][] board, teamBoard;
    static ArrayList<Team>[] teams;
    static int[] tail;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int total;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 격차 크기
        M = Integer.parseInt(st.nextToken()); // 팀 수
        K = Integer.parseInt(st.nextToken()); // 라운드 수

        board = new int[N+1][N+1];
        teamBoard = new int[N+1][N+1];
        teams = new ArrayList[M+1];
        tail = new int[M+1];
        visited = new boolean[N+1][N+1];

        for (int i = 1; i <= M; i++) {
            teams[i] = new ArrayList<>();
        }

        int t = 1;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                board[i][j] = tmp;

                if (tmp == 1)
                    teams[t++].add(new Team(i, j));
            }
        }

        for (int i = 1; i <= M; i++) {
            makeTeam(teams[i].get(0), i);
        }

        for (int i = 1; i <= K; i++) {
            moveTeam();
            int hitTeam = throwBall(i);
            reverseTeam(hitTeam);

        }

        System.out.println(total);
    }

    static void makeTeam(Team head, int teamIdx) {
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[] {head.r, head.c});
        visited[head.r][head.c] = true;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            teamBoard[r][c] = teamIdx;

            for (int d = 0; d < 4; d++) {
                int dr = r + dir[d][0];
                int dc = c + dir[d][1];

                if (dr <= 0 || dr > N || dc <= 0 || dc > N || visited[dr][dc]) continue;
                if (board[dr][dc] == 0) continue;

                // 첫 진행 방향은 2로
                if (board[r][c] == 1 && board[dr][dc] != 2) continue;

                visited[dr][dc] = true;
                teams[teamIdx].add(new Team(dr, dc));

                if (board[dr][dc] == 3){
                    tail[teamIdx] = teams[teamIdx].size();
                }

                q.add(new int[] {dr, dc});
            }
        }
    }

    private static void moveTeam() {
        // 각 팀의 레일을 한 칸씩 뒤로 민다. -> 머리사람 기준 한 칸씩 앞으로 이동
        for (int i = 1; i <= M; i++) {
            int size = teams[i].size() - 1;
            Team tmp = teams[i].get(size);
            for (int j = size; j > 0; j--) {
                teams[i].set(j, teams[i].get(j-1));
            }

            teams[i].set(0, tmp);
        }

        // Board 변경
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < teams[i].size(); j++) {
                Team tmp = teams[i].get(j);

                if (j == 0)
                    board[tmp.r][tmp.c] = 1;
                else if (j < tail[i] - 1)
                    board[tmp.r][tmp.c] = 2;
                else if (j == tail[i] - 1)
                    board[tmp.r][tmp.c] = 3;
                else
                    board[tmp.r][tmp.c] = 4;
            }
        }
    }

    private static int throwBall(int round) {
        int hit = 0;
        int direction = (round - 1) % (4 * N) + 1;

        if (direction <= N) {
            for (int i = 1; i <= N; i++) {
                if (board[direction][i] > 0 && board[direction][i] < 4) {
                    hit = teamBoard[direction][i];
                    updateScore(direction, i, hit);

                    return hit;
                }
            }

        } else if (direction <= (2 * N)) {
            direction -= N;
            for (int i = 1; i <= N; i++) {
                if (board[N + 1 - i][direction] > 0 && board[N + 1 - i][direction] < 4) {
                    hit = teamBoard[N + 1 - i][direction];
                    updateScore(N + 1 - i, direction, hit);

                    return hit;
                }
            }

        } else if (direction <= (3 * N)) {
            direction -= (2 * N);
            for (int i = 1; i <= N; i++) {
                if (board[N + 1 - direction][N + 1 - i] > 0 && board[N + 1 - direction][N + 1 - i] < 4) {
                    hit = teamBoard[N + 1 - direction][N + 1 - i];
                    updateScore(N + 1 - direction, N + 1 - i, hit);

                    return hit;
                }
            }

        } else {
            direction -= (3 * N);
            for (int i = 1; i <= N; i++) {
                if (board[i][N + 1 - direction] > 0 && board[i][N + 1 - direction] < 4) {
                    hit = teamBoard[i][N + 1 - direction];
                    updateScore(i, N + 1 - direction, hit);

                    return hit;
                }
            }
        }

        return hit;
    }

    private static void updateScore(int r, int c, int idx) {
        for (int i = 0, size = teams[idx].size(); i < size; i++) {
            if (teams[idx].get(i).r == r && teams[idx].get(i).c == c) {
                total += (i + 1) * (i + 1);
                break;
            }
        }
    }

    private static void reverseTeam(int hitTeam) {
        if (hitTeam == 0) return;

        ArrayList<Team> tmp = new ArrayList<>();
        for (int i = tail[hitTeam] - 1; i >= 0 ; i--) {
            Team t = teams[hitTeam].get(i);
            tmp.add(t);
        }

        for (int i = teams[hitTeam].size() - 1; i >= tail[hitTeam]; i--) {
            Team t = teams[hitTeam].get(i);
            tmp.add(t);
        }

        for (int i = 0; i < tmp.size(); i++) {
            teams[hitTeam].set(i, tmp.get(i));
        }

        for (int i = 0; i < teams[hitTeam].size(); i++) {
            Team t = teams[hitTeam].get(i);

            if (i == 0)
                board[t.r][t.c] = 1;
            else if (i < tail[hitTeam] - 1)
                board[t.r][t.c] = 2;
            else if (i == tail[hitTeam] - 1)
                board[t.r][t.c] = 3;
            else
                board[t.r][t.c] = 4;
        }
    }
}
