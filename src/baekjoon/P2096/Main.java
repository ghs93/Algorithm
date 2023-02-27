package baekjoon.P2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2096. 내려가기 - 골드 5
 * @author hoseong
 * @category DP
 */
public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[2][N][3];
        dp[0][0][0] = arr[0][0];
        dp[0][0][1] = arr[0][1];
        dp[0][0][2] = arr[0][2];
        dp[1][0][0] = arr[0][0];
        dp[1][0][1] = arr[0][1];
        dp[1][0][2] = arr[0][2];
        for (int i = 1; i < N; i++) {
            dp[0][i][0] = arr[i][0] + Math.max(dp[0][i-1][0], dp[0][i-1][1]);
            dp[0][i][1] = arr[i][1] + Math.max(dp[0][i-1][0], Math.max(dp[0][i-1][1], dp[0][i-1][2]));
            dp[0][i][2] = arr[i][2] + Math.max(dp[0][i-1][1], dp[0][i-1][2]);
            dp[1][i][0] = arr[i][0] + Math.min(dp[1][i-1][0], dp[1][i-1][1]);
            dp[1][i][1] = arr[i][1] + Math.min(dp[1][i-1][0], Math.min(dp[1][i-1][1], dp[1][i-1][2]));
            dp[1][i][2] = arr[i][2] + Math.min(dp[1][i-1][1], dp[1][i-1][2]);
        }

        System.out.println(Math.max(dp[0][N-1][0], Math.max(dp[0][N-1][1], dp[0][N-1][2])) + " " + Math.min(dp[1][N-1][0], Math.min(dp[1][N-1][1], dp[1][N-1][2])));
    }
}
