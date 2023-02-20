package baekjoon.P10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 백준 10026. 적록색약 - 골드 5
 * @author hoseong
 * @category BFS
 */
public class Main {
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        // R -> 82
        // G -> 71
        // B -> 66
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs1(N, map) + " " + bfs2(N, map));
    }

    static int bfs1(int N, int[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visiteed = new boolean[N][N];

        int sec = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visiteed[i][j]) {
                    q.add(new int[] {i, j});
                    visiteed[i][j] = true;
                    sec++;

                    while(!q.isEmpty()) {
                        int[] tmp = q.poll();
                        int target = map[tmp[0]][tmp[1]];

                        for (int d = 0; d < 4; d++) {
                            int dr = tmp[0] + dir[d][0];
                            int dc = tmp[1] + dir[d][1];

                            if(dr < 0 || dr >= N || dc < 0 || dc >= N || visiteed[dr][dc]) continue;

                            if(map[dr][dc] == target) {
                                visiteed[dr][dc] = true;
                                q.add(new int[] {dr, dc});
                            }
                        }
                    }
                }
            }
        }

        return sec;
    }

    static int bfs2(int N, int[][] map) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visiteed = new boolean[N][N];

        int sec = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visiteed[i][j]) {
                    q.add(new int[] {i, j});
                    visiteed[i][j] = true;
                    sec++;

                    while(!q.isEmpty()) {
                        int[] tmp = q.poll();
                        int target = map[tmp[0]][tmp[1]];

                        for (int d = 0; d < 4; d++) {
                            int dr = tmp[0] + dir[d][0];
                            int dc = tmp[1] + dir[d][1];

                            if(dr < 0 || dr >= N || dc < 0 || dc >= N || visiteed[dr][dc]) continue;

                            if((map[dr][dc] == target) ||
                                    ((target == 82 || target == 71) && (map[dr][dc] == 82 || map[dr][dc] == 71))) {
                                visiteed[dr][dc] = true;
                                q.add(new int[]{dr, dc});
                            }
                        }
                    }
                }
            }
        }

        return sec;
    }
}
