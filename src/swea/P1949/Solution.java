package swea.P1949;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * SWEA 1949. 등산로 조성 
 * @author hoseong
 * @category DFS
 */
public class Solution {
	static class Mountain {
		int r, c, h;

		public Mountain(int r, int c, int h) {
			this.r = r;
			this.c = c;
			this.h = h;
		}
	}

	static int[][] map, dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] visited;
	static int N, K, maxLen;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			maxLen = Integer.MIN_VALUE;
			
			ArrayList<Mountain> top = new ArrayList<>();
			top.add(new Mountain(0, 0, 0));
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int m = Integer.parseInt(st.nextToken());
					map[i][j] = m;
					
					if(top.get(0).h < m) {
						top.clear();
					}
					
					if(top.isEmpty() || top.get(0).h == m)
						top.add(new Mountain(i, j, m));
				}
			}
			
			for (Mountain mountain : top) {
				dfs(mountain, false, 1);
			}
			
			System.out.println("#" + tc + " " + maxLen);
		}
	}
	
	private static void dfs(Mountain m, boolean isCut, int len) {
		maxLen = Math.max(maxLen, len);
		
		visited[m.r][m.c] = true;
		
		for (int d = 0; d < 4; d++) {
			int dr = m.r + dir[d][0];
			int dc = m.c + dir[d][1];
			
			if(dr<0 || dr>=N || dc<0 || dc>=N || visited[dr][dc]) continue;
			
			visited[dr][dc] = true;
			if(map[dr][dc] < m.h) {
				dfs(new Mountain(dr, dc, map[dr][dc]), isCut, len+1);
				
			} else if(!isCut && m.h > map[dr][dc] - K) {
				dfs(new Mountain(dr, dc, m.h-1), true, len+1);
			}
			
			visited[dr][dc] = false;
		}
		
		visited[m.r][m.c] = false;
	}
}