package baekjoon.P3197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 3197. 백조의 호수 - 플래티넘 5
 * @author hoseong
 * @category BFS, Union-Find
 */
public class Main {
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		
		int l = 0;
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = s.charAt(j);
				
				if(c == '.') {
					map[i][j] = -2;
					
				} else if(c == 'L') {
					map[i][j] = l++;
					
				} else {
					map[i][j] = -1;
				}
			}
		}
		
		for (int[] m : map) {
			System.out.println(Arrays.toString(m));
		}
		System.out.println();
		
		int p = 2;
		boolean[][] visited;
		Queue<int[]> q = new ArrayDeque<>();
		Queue<int[]> ices = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == -2) {
					q.clear();
					visited = new boolean[R][C];
					
					q.add(new int[] {i, j});
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						int[] m = q.poll();
						
						if(map[m[0]][m[1]] == -2)
							map[m[0]][m[1]] = p;
						
						for (int d = 0; d < 4; d++) {
							int r = m[0] + dir[d][0];
							int c = m[1] + dir[d][1];
							
							if(r<0 || r>=R || c<0 || c>=C || visited[r][c]) continue;
							
							visited[r][c] = true;
							if(map[r][c] == -2) {
								q.add(new int[] {r, c});
								
							} else if(map[r][c] == 1 || map[r][c] == 0) {
								q.add(new int[] {r, c});
								
							} else {
								ices.add(new int[] {r, c});
								map[r][c] = map[i][j];
							}
						}
					}
					
					p++;
				}
			}
		}
		parents = new int[p];
		for (int i = 0; i < p; i++) {
			parents[i] = i;
		}
		
		for (int[] m : map) {
			System.out.println(Arrays.toString(m));
		}
		System.out.println();
		System.out.println(Arrays.toString(parents));
		
		int day=1;
		visited = new boolean[R][C];
		ice: while(!ices.isEmpty()) {
			System.out.println("size: " + ices.size());
			for (int i = 0, size = ices.size(); i < size; i++) {
				int[] ice = ices.poll();
				
				visited[ice[0]][ice[1]] = true;
				for (int d = 0; d < 4; d++) {
					int r = ice[0] + dir[d][0];
					int c = ice[1] + dir[d][1];
					
					if(r<0 || r>=R || c<0 || c>=C || visited[r][c]) continue;
					
					
					if(map[r][c] == -1) {
						ices.add(new int[] {r, c});
						map[r][c] = map[ice[0]][ice[1]];
						
					} else {
						System.out.println("m: " + map[r][c] + ", mi: " + map[ice[0]][ice[1]]);
						if(!union(map[r][c], map[ice[0]][ice[1]])) {
							System.out.println(Arrays.toString(parents));
							if(parents[0] == parents[1]) {
								ices.clear();
								break ice;
							}
						}
					}
				}
			}
		
			day++;
		}
		
		System.out.println(day);
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				
//			}
//		}
	}

	static boolean union(int a, int b) {
		int ar = find(a);
		int br = find(b);
		
		if(ar == br) return true;
		
		parents[br] = ar;
		return false;
	}
	
	static int find(int a) {
		if(parents[a] == a)
			return a;
		
		return parents[a] = find(parents[a]);
	}
}
