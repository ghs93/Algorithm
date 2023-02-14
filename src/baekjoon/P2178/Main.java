package baekjoon.P2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2178. 미로 탐색 - 실버 1
 * @author hoseong
 * @category BFS
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //0 -> 48
        //1 -> 49
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();

            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j-1) - 48;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N+1][M+1];
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        q.add(new int[] {1, 1, 1});
        visited[1][1] = true;

        int step = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if(tmp[0] == N && tmp[1] == M) {
                step = tmp[2];
                break;
            }

            for (int d = 0; d < 4; d++) {
                int dr = tmp[0] + dir[d][0];
                int dc = tmp[1] + dir[d][1];

                if(dr <= 0 || dr > N || dc <= 0 || dc > M) continue;

                if(visited[dr][dc]) continue;

                if(map[dr][dc] == 1) {
                    visited[dr][dc] = true;
                    q.add(new int[] {dr, dc, tmp[2] + 1});
                }
            }
        }

        System.out.println(step);
    }
}