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
	static long[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		dp = new long[N+1][K+1];

		int MOD = 1000000003;
		if(K==1) {
			System.out.println(N);
			
		} else if(N%2 == 0 && K == N/2) {
			System.out.println(2);
			
		} else if (K > N/2){
			System.out.println(0);
			
		} else {
			System.out.println(getCnt(N, K) % MOD);
		}
	}

	public static long getCnt(int N, int K) {
		if(K == 1) {
			return N;
		}
		
		if(N%2 == 0 && K == N/2) {
			return 2;
		}
		
		if(dp[N][K] > 0) {
			return dp[N][K];
			
		} else {
			return dp[N][K] = getCnt(N-2, K-1) + getCnt(N-1, K);
		}
	}
}