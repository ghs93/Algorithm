package baekjoon.P2447;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2447. 별 찍기 - 10 - 골드 5
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
        map = new char[N+1][N+1];

        dfs(1, 1, N, false);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int r, int c, int n, boolean isBlank) {
        if (isBlank) {
            for (int i = r; i < r + n; i++) {
                for (int j = c; j < c + n; j++) {
                    map[i][j] = ' ';
                }
            }

            return;
        }

        if (n == 1) {
            map[r][c] = '*';
            return;
        }

        int size = n / 3;
        int cnt = 1;
        for (int i = r; i < r+n; i += size) {
            for (int j = c; j < c+n; j += size) {
                dfs(i, j, size, cnt == 5);
                cnt++;
            }
        }
    }
}
