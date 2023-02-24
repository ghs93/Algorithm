package baekjoon.P4150;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 백준 4150. 피보나치 수 - 브론즈 1
 * @author hoseong
 * @category 큰 수, DP
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
