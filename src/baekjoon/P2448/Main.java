package baekjoon.P2448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2448. 별 찍기 - 11 - 골드 4
 * @author hoseong
 * @category 재귀
 */
public class Main {
    static StringBuilder sb;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        map = new char[N+1][2*N+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 2*N+1; j++) {
                map[i][j] = ' ';
            }
        }

        dfs(1, N, N);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < 2*N+1; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int r, int c, int n) {
        if (n == 3) {
            map[r][c] = '*';
            map[r+1][c-1] = '*';
            map[r+1][c+1] = '*';
            map[r+2][c-2] = '*';
            map[r+2][c-1] = '*';
            map[r+2][c] = '*';
            map[r+2][c+1] = '*';
            map[r+2][c+2] = '*';

            return;
        }

        dfs(r, c, n/2);
        dfs(r + n/2, c - n/2, n/2);
        dfs(r + n/2, c + n/2, n/2);
    }
}
