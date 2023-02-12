package baekjoon.P9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9461. 파도반 수열 - 실버 3
 * @author hoseong
 * @category DP
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        for (int i = 5; i <= 100; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }

        System.out.println(sb);
    }
}
