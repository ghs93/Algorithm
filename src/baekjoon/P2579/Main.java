package baekjoon.P2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2579. 계단 오르기 - 실버 3
 * @author hoseong
 * @category DP
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] step = new int[N+1];
		int[][] dp = new int[2][N+1]; //dp[0] - 이전 계단을 밟았을 때, dp[1] - 2칸 전 계단을 밟았을 때
		
		for (int i = 1; i <= N; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		
		if(N < 3) {
			int max = 0;
			for (int i = 1; i <= N; i++) {
				max += step[i];
			}
			System.out.println(max);
			
		} else {
			dp[0][1] = dp[1][1] = step[1];
			dp[0][2] = step[1] + step[2];
			dp[1][2] = step[2];
			
			for (int i = 3; i <= N; i++) {
				dp[0][i] = step[i] + dp[1][i-1];
				dp[1][i] = step[i] + Math.max(dp[0][i-2], dp[1][i-2]);
			}
			
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}	
	}
}