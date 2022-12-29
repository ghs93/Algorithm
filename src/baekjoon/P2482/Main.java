package baekjoon.P2482;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2482. 색상환 - 골드 4
 * @author hoseong
 * @category DP 
 */
public class Main {
	static int[][] dp;
	static int MOD = 1000000003;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		dp = new int[N+1][K+1];

		
		if(N/K < 2) {
			System.out.println(0);
			return;
		}
		
		int cnt = getCnt(N, K);
		
		System.out.println(cnt);
	}

	public static int getCnt(int N, int K) {
		if(K == 1) {
			return N;
		}
		
		if(K == (N/2 + N%2)) {
			return 2;
		}
		
		if(dp[N][K] == 0)
			dp[N][K] = (getCnt(N-2, K-1) + getCnt(N-1, K)) % MOD;
		
		return dp[N][K];
	}
}