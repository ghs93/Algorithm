package baekjoon.P12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 12865. 평범한 배낭 - 골드 5
 * @author hoseong
 * @category DP 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		

		int N = Integer.parseInt(st.nextToken()); // 물건 수
		int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
		
		int[] W = new int[N+1]; // 물건 무게
		int[] V = new int[N+1]; // 물건 가지
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] knapsack = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if(j < W[i]) {
					knapsack[i][j] = knapsack[i-1][j];
					
				} else {
					int v = Math.max(knapsack[i-1][j], V[i] + knapsack[i-1][j-W[i]]);
					knapsack[i][j] = v;
				}
			}
		}
		
		System.out.println(knapsack[N][K]);
	}
}