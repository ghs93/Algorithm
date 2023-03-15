package baekjoon.P9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 9252. LCS 2 - 골드 4
 * @author hoseong
 * @category DP, LCS
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] src = br.readLine().toCharArray();
        char[] dest = br.readLine().toCharArray();

        int N = src.length;
        int M = dest.length;

        int[][] dp = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (src[i-1] == dest[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;

                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int result = dp[N][M];

        while (N != 0 && M != 0) {
            int tmp = dp[N][M];

            if (tmp == dp[N-1][M]) {
                N--;

            } else if (tmp == dp[N][M-1]) {
                M--;

            } else {
                sb.append(src[N-1]);
                N--;
                M--;
            }
        }

        sb.reverse();
        sb.insert(0, '\n').insert(0, result);
        System.out.println(sb);
    }
}