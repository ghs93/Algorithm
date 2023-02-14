package baekjoon.P1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1992. 쿼드트리 - 실버 1
 * @author hoseong
 * @category DFS, 분할 정복
 */
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - 48;
            }
        }

        dfs(N, 0, 0);
        System.out.println(sb);
    }

    static void dfs(int size, int r, int c) {
        if(size == 1) {
            sb.append(map[r][c]);
            return;
        }

        if(check(size, r, c)) {
            sb.append(map[r][c]);

        } else {
            sb.append('(');

            int half = size / 2;
            dfs(half, r, c);
            dfs(half, r, c + half);
            dfs(half, r + half, c);
            dfs(half, r + half, c + half);
            sb.append(')');
        }
    }

    static boolean check(int size, int r, int c) {
        int stand = map[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(stand != map[i][j])
                    return false;
            }
        }

        return true;
    }
}
