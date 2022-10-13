package swea.P2112;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 2112. 보호 필름 
 * @author hoseong
 * @category 부분집합, 백트래킹
 */
public class Solution {
	static int D, W, K, film[][], result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			result = Integer.MAX_VALUE;
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			subSet(0, 0);
			System.out.println("#" + tc + " " + result);
		}
	}
	
	private static void subSet(int cnt, int drug) {
		if(result <= drug) {
			return;
		}
		
		if(check()) {
			result = Math.min(result, drug);
			return;
		}
		
		if(cnt == D) {
			return;
		}
		
		int[] temp = new int[W];
		for (int i = 0; i < W; i++) {
			temp[i] = film[cnt][i];
		}
		
		//그대로
		subSet(cnt+1, drug);
		
		//A로
		for (int i = 0; i < W; i++) {
			film[cnt][i] = 0;
		}
		subSet(cnt+1, drug+1);
		
		//B로
		for (int i = 0; i < W; i++) {
			film[cnt][i] = 1;
		}
		subSet(cnt+1, drug+1);
		
		//복구
		for (int i = 0; i < W; i++) {
			film[cnt][i] = temp[i];
		}
	}
	
	private static boolean check() {
		boolean pass = true;
		for (int i = 0; i < W; i++) {
			int cell = 0;
			int c = film[0][i];
			int size = 1;
			
			for (int j = 1; j < D; j++) {
				if(c == film[j][i]) {
					size++;
					
				} else {
					cell = Math.max(cell, size);
					c = film[j][i];
					size = 1;
				}
			}
			
			cell = Math.max(cell, size);
			if(cell < K) {
				pass = false;
				break;
			}
		}
		
		return pass;
	}
}