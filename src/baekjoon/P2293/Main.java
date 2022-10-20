package baekjoon.P2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2293. 동전 - 골드 5
 * @author hoseong
 * @category DP
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N+1];
		int[] dp = new int[K+1];
		
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 1; i <= N; i++) {
			if(nums[i] > K) continue;
			
			dp[nums[i]] += 1;
			
			for (int j = nums[i]+1; j <= K; j++) {
				dp[j] += dp[j - nums[i]];
			}
		}
		
		System.out.println(dp[K]);
	}
}