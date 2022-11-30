package baekjoon.P9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 9466. 텀 프로젝트 - 골드 3
 * @author hoseong
 * @category DFS
 */
public class Main {
    static int[] arr;
	static boolean[] visited;
    static boolean[] result;
    static int total;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			total = 0;
			arr = new int[N+1];
			visited = new boolean[N+1]; //방문처리를 위한 배열
			result = new boolean[N+1]; //사이클 검사 진행 여부를 위한 배열
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int target = Integer.parseInt(st.nextToken()); 
				arr[i] = target;
			}
			
			for (int i = 1; i <= N; i++) {
				if(!result[i]) //사이클 검사를 한 적이 없으면 dfs 진행
					dfs(i);
			}
			
			sb.append(N-total).append('\n');
		}
		
		System.out.println(sb);
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		
		int next = arr[cur];
		if(!visited[next]) { //팀을 짜고 싶은 사람을 방문한 적이 없으면 방문
			dfs(next);
			
		} else { //팀을 짜고 싶은 사람을 방문한 적이 있으면
			if(!result[next]) { //사이클 형성을 해본적이 있나 검사
				total++;
				
				while(cur != next) {
					total++;
					next = arr[next];
				}
			}
		}
		
		result[cur] = true;
	}
}
