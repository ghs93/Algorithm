package baekjoon.P2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2638. 치즈 - 골드 3
 * @author hoseong
 * @category BFS
 */
public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static Queue<int[]> temp = new ArrayDeque<>();
    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[][] check;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int cheese = Integer.parseInt(st.nextToken());
                map[i][j] = cheese;

                if (cheese > 0) {
                    q.add(new int[] {i, j});
                }
            }
        }

        temp = new ArrayDeque<>();
        map[0][0] = -1;

        while (!q.isEmpty()) {
            temp.add(new int[] {0, 0});
            check = new boolean[N][M];
            check[0][0] = true;
            findOut();

            melt();
        }

        System.out.println(result);
    }

    static void melt() {
        for (int i = 0, size = q.size(); i < size; i++) {
            int[] cheese = q.poll();

            int isMelt = 0;
            for (int d = 0; d < 4; d++) {
                int dr = cheese[0] + dir[d][0];
                int dc = cheese[1] + dir[d][1];

                if(dr<0 || dr>=N || dc<0 || dc>=M) continue;

                if(map[dr][dc] == -1)
                    isMelt++;
            }

            if(isMelt > 1) {
                map[cheese[0]][cheese[1]] = 0;

            } else {
                q.add(cheese);
            }
        }

        result++;
    }

    static void findOut() {
        while (!temp.isEmpty()) {
            int[] tmp = temp.poll();

            for (int d = 0; d < 4; d++) {
                int dr = tmp[0] + dir[d][0];
                int dc = tmp[1] + dir[d][1];

                if(dr<0 || dr>=N || dc<0 || dc>=M || check[dr][dc] || map[dr][dc] == 1) continue;

                check[dr][dc] = true;
                map[dr][dc] = -1;
                temp.add(new int[] {dr, dc});
            }
        }
    }
}
