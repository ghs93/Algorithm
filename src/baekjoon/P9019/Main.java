package baekjoon.P9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 9019. DSLR - 골드 4
 * @author hoseong
 * @category BFS
 */
public class Main {
	static class DSLR {
		int cur;
		String dslr;
		
		public DSLR(int cur, String dslr) {
			this.cur = cur;
			this.dslr = dslr;
		}
	}
	
	static char[] dslr = {'D', 'S', 'L', 'R'};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			boolean[] visited = new boolean[100001];
			Queue<DSLR> q = new ArrayDeque<>();
			q.add(new DSLR(from, ""));
			visited[from] = true;
			
			DSLR result = null;
			while(!q.isEmpty()) {
				DSLR f = q.poll();
				
				if(f.cur == to) {
					result = f;
					break;
				}
				
				for (int i = 0; i < 4; i++) {
					char d = dslr[i];
					
					int tmp = 0;
					if(d == 'D') {
						tmp = (f.cur * 2) % 10000;
						
					} else if(d == 'S') {
						tmp = f.cur - 1;
						if(tmp < 0) {
							tmp = 9999;
						}
						
					} else if(d == 'L') {
						tmp = (f.cur % 1000) * 10;
						tmp += f.cur/1000;
						
					} else {
						tmp = (f.cur/10);
						tmp += (f.cur%10) * 1000;
					}
					
					if(visited[tmp]) continue;
					
					visited[tmp] = true;
					q.add(new DSLR(tmp, f.dslr + d));
				}
			}
			
			sb.append(result.dslr).append('\n');
		}
		
		System.out.println(sb);
	}
}