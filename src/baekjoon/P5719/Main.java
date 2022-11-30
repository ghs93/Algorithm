package baekjoon.P5719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 5719. 거의 최단 경로 - 플래티넘 5
 * @author hoseong
 * @category 데이크스트라
 */
public class Main {
	static class Node implements Comparable<Node> {
		int to, weight;
        boolean isVisited;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
            this.isVisited = false;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static List<Node>[] nodes;
	static Node[] nArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) break;
			
			nodes = new ArrayList[N];

			for (int i = 0; i < N; i++) {
				nodes[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int U = Integer.parseInt(st.nextToken());				
				int V = Integer.parseInt(st.nextToken());				
				int P = Integer.parseInt(st.nextToken());
				
				nodes[U].add(new Node(V, P));
			}
			
			nArr = new Node[N];
			int min = dijkstra(S, D, N)[D];
			deletePath(D);
			
			int next = 0;
			while(true) {
				Arrays.fill(nArr, null);
				next = dijkstra(S, D, N)[D];
				
				if(min != next)
					break;
				
				deletePath(D);
			}
			
			sb.append(next == Integer.MAX_VALUE ? -1 : next).append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static int[] dijkstra(int start, int end, int N) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int[] d = new int[N];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		pq.add(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			
			if(n.weight > d[n.to]) continue;
			
			for (Node nd : nodes[n.to]) {
                if(nd.isVisited) continue;
                
				int cost = d[n.to] + nd.weight;
				
				if(d[nd.to] > cost) {
					d[nd.to] = cost;
					pq.add(new Node(nd.to, cost));
					nArr[nd.to] = n;
				}
			}
		}
		
		return d;
	}
	
	static void deletePath(int end) {
		Node e = nArr[end];
		int from = end;
		while(e != null) {
			for (Node nd : nodes[e.to]) {
				if(nd.to == from) {
                    nd.isVisited = true;
					break;
				}
			}
			
			from = e.to;
			e = nArr[e.to];
		}
	}
}
