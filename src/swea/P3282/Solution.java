package swea.P3282;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 3282. Kapnsack
 * @author hoseong
 * @category DP
 */
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //물건 수
			int K = Integer.parseInt(st.nextToken()); //가방 부피
			
			int[] V = new int[N+1]; //부피
			int[] C = new int[N+1]; //가치
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				V[i] = Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] knapsack = new int[N+1][K+1];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= K; j++) {
					if(j < V[i]) { //현재 가방의 부피가 물건의 부피보다 작으면
						//이전 최적해 사용
						knapsack[i][j] = knapsack[i-1][j];
						
					} else { //현재 가방의 부피가 물건의 부피보다 크거나 같으면
						//최적해 구하기
						int c =  Math.max(knapsack[i-1][j], C[i] + knapsack[i-1][j - V[i]]);
						knapsack[i][j] = c;
					}
				}
			}
			
			System.out.println("#" + tc + " " + knapsack[N][K]);
		}
	}
}