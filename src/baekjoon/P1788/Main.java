package baekjoon.P1788;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1788. 피보나치 수의 확장 - 실버 3
 * @author hoseong
 * @category DP
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 0) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        int absN = Math.abs(N);
        int[] dp = new int[absN + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= absN; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;
        }

        if (N < 0) {
            if (absN % 2 == 0) {
                System.out.println(-1);

            } else {
                System.out.println(1);
            }

        } else {
            System.out.println(1);
        }

        System.out.println(dp[absN]);
    }
}
