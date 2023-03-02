package swea.P1868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * SWEA 1868. 파핑파핑 지뢰찾기
 * @author hoseong
 * @category BFS
 */
public class Solution {
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++)
        {
            sb.append('#').append(test_case).append(' ');
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    if (str.charAt(j) == '.')
                        map[i][j] = 0;
                    else
                        map[i][j] = -1;
                }
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0 && find(i, j) == 0) {
                        result++;
                        bfs(i, j);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) result++;
                }
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});
        map[r][c] = 1;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int d = 0; d < 8; d++) {
                int dr = tmp[0] + dir[d][0];
                int dc = tmp[1] + dir[d][1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= N || map[dr][dc] != 0) continue;

                int f = find(dr, dc);
                if (f == 0) {
                    q.add(new int[] {dr, dc});
                }

                map[dr][dc] = 1;
            }
        }
    }

    static int find(int r, int c) {
        int result = 0;
        for (int d = 0; d < 8; d++) {
            int dr = r + dir[d][0];
            int dc = c + dir[d][1];

            if (dr < 0 || dr >= N || dc < 0 || dc >= N) continue;

            if (map[dr][dc] == -1) result++;
        }

        return result;
    }
}
