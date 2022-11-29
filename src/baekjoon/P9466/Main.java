package baekjoon.P9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 9466. 텀 프로젝트 - 골드 3
 * @author hoseong
 * @category 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N+1];
			boolean[] visited = new boolean[N+1];
			for (int i = 1; i <= N; i++) {
				int target = Integer.parseInt(st.nextToken()); 
				arr[i] = target;
				
				if(target == i)
					visited[i] = true;
			}
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i])
					visited[i] = dfs(i, arr[i], arr, visited);
			}
			
//			System.out.println(Arrays.toString(visited));
			
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if(!visited[i])
					cnt++;
			}
			
			sb.append(cnt).append('\n');
		}
		
		System.out.println(sb);
	}

	private static boolean dfs(int start, int cur, int[] arr, boolean[] visited) {
		if(visited[cur])
			return false;
		
		if(start == cur)
			return true;
		
		boolean t = dfs(start, arr[cur], arr, visited);
		return visited[cur] = t;
	}

}
