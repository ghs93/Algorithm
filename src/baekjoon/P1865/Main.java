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

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); //지점 수
			int M = Integer.parseInt(st.nextToken()); //도로 수
			int W = Integer.parseInt(st.nextToken()); //웜홀 수
			
			long[] path = new long[N+1];
			Arrays.fill(path, Long.MAX_VALUE);
			path[1] = 0;
			
			List<Edge> edges = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
			}
		}
	}

}
