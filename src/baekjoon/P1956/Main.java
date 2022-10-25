package baekjoon.P1956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1956. 운동 - 골드 4
 * @author hoseong
 * @category 플로이드-워셜
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[V+1][V+1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			map[from][to] = weight;
		}
		
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				for (int k = 1; k <= V; k++) {
					if(map[i][k] != 0 && map[k][j] != 0) {
						if(map[i][j] == 0)
							map[i][j] = map[i][k] + map[k][j];
						else
							map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
				
				if(i ==j && map[i][j] != 0) {
					min = Math.min(min, map[i][j]);
				}
			}
		}
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
}