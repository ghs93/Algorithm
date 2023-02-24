package baekjoon.P10826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 백준 10826. 피보나치 수 4 - 실버 5
 * @author hoseong
 * @category DP, 큰 수
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N < 2) {
            System.out.println(N);
            return;
        }

        BigInteger[] dp = new BigInteger[N+1];

        dp[0] = BigInteger.valueOf(0);
        dp[1] = BigInteger.valueOf(1);

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1].add(dp[i-2]);
        }

        System.out.println(dp[N]);
    }
}
