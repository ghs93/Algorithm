package swea.P4014;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 4014. 활주로 건설 
 * @author hoseong
 * @category 구현
 */
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N*2][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());				
				for (int j = 0; j < N; j++) {
					map[j+N][i] = map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int roadCnt = 0;
			road: for (int i = 0; i < N*2; i++) {
				int height = map[i][0];
				int size = 1;
				
				for (int j = 1; j < N; j++) {
					if(height == map[i][j]) {
						size++;
						
					} else if(height+1 == map[i][j]) {
						if(size < X) continue road;
						
						height++;
						size = 1;
						
					} else if(height-1 == map[i][j]) {
						int cnt = 0;
						int M = Math.min(N, j+X);
						for (int t = j; t < M; t++) {
							if(map[i][t] == height-1) cnt++;
						}
						
						if(cnt < X) continue road;
						
						height--;
						j += cnt-1;
						size = 0;
						
					} else {
						continue road;
					}
				}
				
				roadCnt++;
			}
			
			System.out.println("#" + tc + " " + roadCnt);
		}
	}
}