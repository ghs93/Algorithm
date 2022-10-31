package baekjoon.P1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 1865. 웜홀 - 골드 3
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
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); //지점 수
			int M = Integer.parseInt(st.nextToken()); //도로 수
			int W = Integer.parseInt(st.nextToken()); //웜홀 수
			
			List<Edge> edges = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				edges.add(new Edge(S, E, T));
				edges.add(new Edge(E, S, T));
			}
			
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				
				edges.add(new Edge(S, E, T * -1));
			}
			
			long[] path = new long[N+1];
			boolean isPossible = false;
			Arrays.fill(path, Integer.MAX_VALUE);
			path[1] = 0;

			for (int i = 1; i <= N-1; i++) {
				for (Edge edge : edges) {
					path[edge.to] = Math.min(path[edge.to], path[edge.from] + edge.weight);
				}
			}
			
			for (Edge edge : edges) {
				if(path[edge.to] > path[edge.from] + edge.weight) {
					isPossible = true;
					break;
				}
			}

			System.out.println(isPossible ? "YES" : "NO");
		}
	}
}
