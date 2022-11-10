package baekjoon.P16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 16928. 뱀과 사다리 게임 - 골드 5
 * @author hoseong
 * @category BFS
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] map = new int[101];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			map[s] = e;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			map[s] = e * -1;
		}

		boolean[] visited = new boolean[101];
		Queue<int[]> q = new ArrayDeque<>();

		q.add(new int[] { 1, 0 });

		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int posi = cur[0];
			int step = cur[1];
			visited[posi] = true;

			if (posi == 100) {
				min = Math.min(min, step);
				continue;
			}

			for (int i = 1; i <= 6; i++) {
				int next = posi + i;

				if (next > 100)
					break;
				
				if (visited[next])
					continue;

				if (map[next] > 0) {
					q.add(new int[] { map[next], step + 1 });

				} else if (map[next] == 0) {
					q.add(new int[] { next, step + 1 });
					
				} else {
					int p = map[next] * -1;
					
					if(!visited[p])
						q.add(new int[] {p, step+1});
				}
			}
		}
		
		System.out.println(min);
	}
}