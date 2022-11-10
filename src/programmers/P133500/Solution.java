package programmers.P133500;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * Programmers 133500. 등대 
 * @author hoseong 
 * @category 
 */
public class Solution {

	public static void main(String[] args) {
		int result1 = solution(8, new int[][] {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}});
		int result2 = solution(10, new int[][] {{4, 1}, {5, 1}, {5, 6}, {7, 	6}, {1, 2}, {1, 3}, {6, 8}, {2, 9}, {9, 10}});
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

	public static int solution(int n, int[][] lighthouse) {
        Node[] nodes = new Node[n+1];
        for (int i = 0; i <= n; i++) {
			nodes[i] = new Node(i, 0);
		}
        
        //루트노드 찾기(연결된 간선이 가장 많은 노드)
        int root = 0, maxConn = 0;
        for (int i = 0; i < n-1; i++) {
			int from = lighthouse[i][0];
			int to = lighthouse[i][1];
			
			nodes[from].add(to);
			nodes[to].add(from);
			
			if(maxConn < nodes[from].connection) {
				root = from;
				maxConn = nodes[from].connection;
			}
			
			if(maxConn < nodes[to].connection) {
				root = to;
				maxConn = nodes[to].connection;
			}
		}
        
        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        //루트의 불을 켰을 때
        int onRoot = 0;
        q.add(nodes[root]);
        while(!q.isEmpty()) {
        	Node node = q.poll();
        	visited[node.from] = true;
        	
        	//불 켜기
        	onRoot++;
        	
        	//자식의 자식 추가
        	for (int to : node.to) {
				//자식 노드가 리프노드면 건너뛰기
        		if(nodes[to].connection < 2 || visited[to]) continue;
        		
        		visited[to] = true;
        		boolean check = true;
        		for (int t : nodes[to].to) {
        			if(visited[t]) continue;
        			
        			//자식 모두가 리프노드 인가 검사
					if(nodes[t].connection > 1)
						check = false;
					
					q.add(nodes[t]);
				}
        		
        		//자식노드의 자식들이 모두 리프노드일 경우
        		if(check) {
        			for (int t : nodes[to].to) {
    					q.remove(nodes[t]);
    				}
        			
        			q.add(nodes[to]);
        		}
			}
        }
        
        Arrays.fill(visited, false);
        
        //루트노드의 불을 껐을 때
        int offRoot = 0;
        visited[root] = true;
        for(int to : nodes[root].to)
        	q.add(nodes[to]);
        
        while(!q.isEmpty()) {
        	Node node = q.poll();
        	visited[node.from] = true;
        	
        	offRoot++;
        	
        	//자식의 자식 추가
        	for (int to : node.to) {
				//자식 노드가 리프노드면 건너뛰기
        		if(nodes[to].connection < 2 || visited[to]) continue;
        		
        		visited[to] = true;
        		boolean check = true;
        		for (int t : nodes[to].to) {
        			if(visited[t]) continue;
        			
        			//자식 모두가 리프노드 인가 검사
					if(nodes[t].connection > 1)
						check = false;
					
					q.add(nodes[t]);
				}
        		
        		//자식노드의 자식들이 모두 리프노드일 경우
        		if(check) {
        			for (int t : nodes[to].to) {
    					q.remove(nodes[t]);
    				}
        			
        			q.add(nodes[to]);
        		}
			}
        }
        System.out.println("on: " + onRoot + ", off: " + offRoot);
        return Math.min(onRoot, offRoot);
    }
	
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
}
