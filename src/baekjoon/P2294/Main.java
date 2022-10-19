package baekjoon.P2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2294. 동전 2 - 골드 5
 * @author hoseong
 * @category DP
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //동전 종류
		int K = Integer.parseInt(st.nextToken()); //가치의 합
		
		int[] coin = new int[N];
		int[] dp = new int[K+1];
		
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.fill(dp, K+1);
		
		dp[0] = 0;
		for (int i = 1; i <= K; i++) {
			for (int j = 0; j < N; j++) {
				if(i >= coin[j]) {
					dp[i] = Math.min(dp[i], dp[i - coin[j]]+1);
				}
			}
		}
		
		if(dp[K] == K+1)
			System.out.println(-1);
		else
			System.out.println(dp[K]);
	}
}
