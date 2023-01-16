package baekjoon.P12852;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 12852. 1로 만들기 2 - 실버 1
 * @author hoseong
 * @category DP
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] visit = new int[n+1];
        Arrays.fill(dp, n+1);

        dp[1] = 0;
        visit[1] = 1;
        for (int i = 2; i <= n; i++) {
            if(i % 3 == 0 && dp[i] > dp[i / 3] + 1){
                dp[i] = dp[i / 3] + 1;
                visit[i] = i / 3;
            }

            if(i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                visit[i] = i / 2;
            }

            if(dp[i] > dp[i-1] + 1) {
                dp[i] = dp[i-1] + 1;
                visit[i] = i - 1;
            }
        }

        System.out.println(dp[n]);

        int v = n;
        for (int i = 0; i <= dp[n]; i++) {
            sb.append(v).append(' ');
            v = visit[v];
        }

        System.out.println(sb);
    }
}
