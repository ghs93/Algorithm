package baekjoon.P7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 7569. 토마토 - 골드 5
 * @author hoseong
 * @category BFS
 */
public class Main {
	static int M, N, H, map[][][];
	static int zCnt, mCnt;
	static Queue<int[]> q;
	static int[][] dir = {{0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		q = new ArrayDeque<>();
		map = new int[H][N][M];
		
		for (int i = 0; i < H; i++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					int t = Integer.parseInt(st.nextToken());
					map[i][n][m] = t;
					
					if(t == 0)
						zCnt++;
					else if(t < 0)
						mCnt++;
					else
						q.add(new int[] {i, n, m});
				}
			}
		}
		
		//System.out.println("1: " + zCnt);
		
		if(zCnt == 0) {
			System.out.println(0);
			
		} else {
			int result = bfs();
			
			/*System.out.println("2: " + zCnt);
			
			for (int[][] mp : map) {
				for (int[] m : mp) {
					System.out.println(Arrays.toString(m));
				}
			}*/
			
			if(zCnt > 0)
				System.out.println(-1);
			else
				System.out.println(result);
		}
	}

	static int bfs() {
		int day = 0;
		boolean[][][] visited = new boolean[H][N][M];
		
		while(!q.isEmpty()) {
			for (int i = 0, size = q.size(); i < size; i++) {
				int[] tomato = q.poll();
				int h = tomato[0];
				int r = tomato[1];
				int c = tomato[2];
				
				visited[h][r][c] = true;
				
				for (int d = 0; d < 6; d++) {
					int dh = h + dir[d][0];
					int dr = r + dir[d][1];
					int dc = c + dir[d][2];
					
					if(dh<0 || dh>=H || dr<0 || dr>=N || dc<0 || dc>=M || visited[dh][dr][dc]) continue;
					
					int t = map[dh][dr][dc];
					visited[dh][dr][dc] = true;
					
					if(t == 0) {
						zCnt--;
						map[dh][dr][dc] = 1;
						q.add(new int[] {dh, dr, dc});
					}
				}				
			}
			
			 day++;
		}
		
		return day-1;
	}
}
