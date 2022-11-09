package baekjoon.P14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 14500. 테트로미노 - 골드 4
 * @author hoseong
 * @category BFS, 구현
 */
public class Main {
	static int N, M, map[][];
	static PriorityQueue<Integer> result;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new PriorityQueue<>(Collections.reverseOrder());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 1, map[i][j]); //ㅗ모양 제외한 모든 블럭 탐색
				bfs(i, j); //ㅗ모양 탐색
			}
		}
		
		System.out.println(result.poll());
	}

	static void dfs(int r, int c, int step, int sum) {
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int dr = r + dir[d][0];
			int dc = c + dir[d][1];
			
			if(dr<0 || dr>=N || dc<0 || dc>=M || visited[dr][dc]) continue;
			
			if(step < 3) {
				dfs(dr, dc, step+1, sum+map[dr][dc]);
				
			} else {
				result.add(sum+map[dr][dc]);
			}
		}
		
		visited[r][c] = false;
	}
	
	private static void bfs(int r, int c) {
		int basic = map[r][c];
		loop: for (int i = 0; i < 4; i++) {
			int sum = basic;
			for (int j = i; j < i+3; j++) {
				int d = j % 4;
				
				int dr = r + dir[d][0];
				int dc = c + dir[d][1];
				
				if(dr<0 || dr>=N || dc<0 || dc>=M || visited[dr][dc]) continue loop;
				
				sum += map[dr][dc];
			}
			
			if(result.peek() < sum) {
				result.add(sum);
			}
		}
	}
}
