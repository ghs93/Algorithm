package baekjoon.P15486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 15486. 퇴사2 - 골드 5
 * @author hoseong
 * @category DP 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	

		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		int[] dp = new int[N+2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N; i > 0; i--) {
			//i번째 작업이 범위를 벗어나지 않을 경우
			if(i + T[i] <= N + 1) {
				//현재 위치에서의 총 수익과 이전 위치에서의 총 수익 중 큰 값 사용
				dp[i] = Math.max(P[i] + dp[i + T[i]], dp[i+1]);
				
			} else {
				//i번째 작업이 범위를 벗어난 경우
				//이전 값 사용
				dp[i] = dp[i+1];
			}
		}
		System.out.println(dp[1]);
	}
}