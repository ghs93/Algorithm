package baekjoon.P9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 9465. 스티커 - 실버 1
 * @author hoseong
 * @category dp
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            int[][] dp = new int[3][n];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            for (int i = 1; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + arr[1][i];
                dp[2][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1]));
            }

            sb.append(Math.max(dp[0][n-1], Math.max(dp[1][n-1], dp[2][n-1]))).append('\n');
        }

        System.out.print(sb);
    }
}
