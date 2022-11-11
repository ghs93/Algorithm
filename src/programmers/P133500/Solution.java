package programmers.P133500;

import java.util.ArrayList;

/**
 * Programmers 133500. 등대 
 * @author hoseong 
 * @category DP
 */
public class Solution {
	static class Node {
		ArrayList<Integer> to;
		int from, connection;

		public Node(int from, int connection) {
			this.from = from;
			this.connection = connection;
			to = new ArrayList<>();
		}
		
		public void add(int to) {
			this.to.add(to);
			connection++;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", from=" + from + ", connection=" + connection + "]";
		}
	}

	public static void main(String[] args) {
		int result1 = solution(8, new int[][] {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}});
		int result2 = solution(10, new int[][] {{4, 1}, {5, 1}, {5, 6}, {7, 6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}});
		int result3 = solution(5, new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}});
		int result4 = solution(13, new int[][] {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 6}, {4, 7}, {5, 8}, {3, 9}, {9, 10}, {9, 11}, {9, 12}, {11, 13}});
		int result5 = solution(2, new int[][] {{1,2}});
		int result6 = solution(10, new int[][] {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {6, 7}, {6, 8}, {6, 9}, {5, 10}});
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		System.out.println(result6);
	}

	static Node[] nodes;
	public static int solution(int n, int[][] lighthouse) {
		if(n == 2)
			return 1;
		
        nodes = new Node[n+1];
        for (int i = 0; i <= n; i++) {
			nodes[i] = new Node(i, 0);
		}
        
        for (int i = 0; i < n-1; i++) {
			int from = lighthouse[i][0];
			int to = lighthouse[i][1];
			
			nodes[from].add(to);
			nodes[to].add(from);
		}
        
        boolean[] visited = new boolean[n+1];
        int[][] dp = new int[2][n+1];
        
        getDp(nodes[1], visited, dp);
        
        return Math.min(dp[0][1], dp[1][1]);
    }
	
	public static void getDp(Node node, boolean[] visited, int[][] dp) {
		visited[node.from] = true;
		
		int on = 1, off = 0;
		for (int to : node.to) {
			if(visited[to]) continue;
			
			getDp(nodes[to], visited, dp);
			
			on += Math.min(dp[0][to], dp[1][to]);
			off += dp[0][to];
		}
		
		dp[0][node.from] = on;
		dp[1][node.from] = off;
	}
}
