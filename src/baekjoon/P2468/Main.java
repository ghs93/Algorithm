package baekjoon.P2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2468. 안전 영역 - 실버 1
 * @author hoseong
 * @category BFS, DFS
 */
public class Main {
    static int n;
    static int[][] map;
    static int min = 100, max = 1;
    static int safeArea = 1;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int h = Integer.parseInt(st.nextToken());
                map[i][j] = h;

                min = Math.min(min, h);
                max = Math.max(max, h);
            }
        }

        for (int h = min; h < max; h++) {
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > h && !visited[i][j]) {
                        cnt++;
//                        dfs(h, i, j);
                        bfs(h, i, j);
                    }
                }
            }

            safeArea = Math.max(safeArea, cnt);
            resetVisited();
        }

        System.out.println(safeArea);
    }

//    private static void dfs(int height, int x, int y) {
//        for (int d = 0; d < 4; d++) {
//            int dx = x + dir[d][0];
//            int dy = y + dir[d][1];
//
//            if (dx < 0 || dx >= n || dy < 0 || dy >= n || visited[dx][dy]) continue;
//            if (map[dx][dy] <= height) continue;
//
//            visited[dx][dy] = true;
//            dfs(height, dx, dy);
//        }
//    }

    private static void bfs(int height, int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            for (int d = 0; d < 4; d++) {
                int dx = tmp[0] + dir[d][0];
                int dy = tmp[1] + dir[d][1];

                if (dx < 0 || dx >= n || dy < 0 || dy >= n || visited[dx][dy]) continue;
                if (map[dx][dy] <= height) continue;

                visited[dx][dy] = true;
                q.add(new int[] {dx, dy});
            }
        }
    }

    static void resetVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }
}
