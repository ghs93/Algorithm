package baekjoon.P2533;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 2533. 사회망 서비스(SNS) - 골드 3
 * @author hoseong
 * @category 트리 DP
 */
public class Main {
	static int N;
	static Node[] nodes;
	static int[][] dp;
	static boolean[] visited;
	
	static class Node {
		int from;
		ArrayList<Integer> to;
		
		public Node(int from) {
			this.from = from;
			to = new ArrayList<>();
		}
		
		public void add(int to) {
			this.to.add(to);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		if(N < 4) {
			System.out.println(1);
			return;
		}
		
		nodes = new Node[N+1];
		for(int i=0; i<=N; i++) {
			nodes[i] = new Node(i);
		}
		
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			nodes[from].add(to);
			nodes[to].add(from);
		}
		dp = new int[2][N+1];
		visited = new boolean[N+1];
		
		dfs(nodes[1]);
		
		System.out.println(Math.min(dp[0][1], dp[1][1]));
	}

	public static void dfs(Node node) {
		visited[node.from] = true;
		
		int off = 0, on = 1;
		for(int to : node.to) {
			if(visited[to]) continue;
			
			dfs(nodes[to]);
			
			on += Math.min(dp[0][to], dp[1][to]);
			off += dp[0][to];
		}
		
		dp[0][node.from] = on;
		dp[1][node.from] = off; 
	}
}
