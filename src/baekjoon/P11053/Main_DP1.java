package baekjoon.P11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 11053. 가장 긴 증가하는 부분 수열 - 실버 2
 * 일반 DP 사용
 * @author hoseong
 * @category DP
 */
public class Main_DP1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j]+1)
					dp[i] = dp[j] + 1;				
			}
			
			System.out.println(Arrays.toString(dp));
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}