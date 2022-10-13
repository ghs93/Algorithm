package swea.P2117;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * SWEA 2117. 홈 방범 서비스 
 * @author hoseong
 * @category 구현
 */
public class Solution {
	static class House {
		int r, c;

		public House(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
		public int getDist(int r, int c) {
			return Math.abs(this.r - r) + Math.abs(this.c - c);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			ArrayList<House> house = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int m = Integer.parseInt(st.nextToken());
					
					if(m != 0)
						house.add(new House(i, j));
				}
			}
			
			int K = 0, maxCost = M*house.size();
			for (int i = 1; i <= N; i++) {
				int k = getCost(i);
				
				if(k<maxCost)
					K = k;
				else
					break;
			}
			
			int maxHouse = 0;
			find: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 1; k <= K; k++) {
						int cost = getCost(k);
						
						int hCnt = 0;
						for (House h : house) {
							if(h.getDist(i, j) <= k-1)
								hCnt++;
						}
						
						if(hCnt*M >= cost)
							maxHouse = Math.max(maxHouse, hCnt);
					}
					
					if(maxHouse >= house.size()) break find;
				}
			}
			
			System.out.println("#" + tc + " " + maxHouse);
		}
	}
	
	static int getCost(int k) {
		return k * k + (k-1) * (k-1);
	}
}