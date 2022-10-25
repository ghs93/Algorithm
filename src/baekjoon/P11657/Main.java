package baekjoon.P11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 11657. 타임머신 - 골드 4
 * @author hoseong
 * @category 벨만-포드
 */
public class Main {
	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); //도시 수
		int M = Integer.parseInt(st.nextToken()); //버스 노선 수
		
		long[] path = new long[N+1];
		Arrays.fill(path, Long.MAX_VALUE);
		path[1] = 0;
		
		List<Edge> edges = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(from, to, weight));
		}
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M; j++) {
				Edge edge = edges.get(j);
				
				if(path[edge.from] != Long.MAX_VALUE) {
					path[edge.to] = Math.min(path[edge.to], path[edge.from] + edge.weight);
				}
			}
		}
		
		//음수 사이클 체크
		for (int j = 0; j < M; j++) {
			Edge edge = edges.get(j);
			
			if(path[edge.from] != Long.MAX_VALUE && path[edge.to] > path[edge.from] + edge.weight) {
				System.out.println(-1);
				return;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(path[i] == Long.MAX_VALUE ? -1 : path[i]).append('\n');
		}
		System.out.print(sb);
	}

}
