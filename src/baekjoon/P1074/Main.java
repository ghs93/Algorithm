package baekjoon.P1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1074. Z - 실버 1
 * @author hoseong
 * @category DFS
 */
public class Main {
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		dfs((int)Math.pow(2, N), R, C);
		System.out.println(count);
	}

	static void dfs(int size, int r, int c) {
		if(size == 1)
			return;
		
		int half = size / 2;
		int block = half * half;

		if(r < half && c < half) {
			dfs(half, r, c);
			
		} else if(r < half && c >= half) {
			count += block;
			dfs(half, r, c - half);
			
		} else if(r >= half && c < half) {
			count += block * 2;
			dfs(half, r - half, c);
			
		} else {
			count += block * 3;
			dfs(half, r - half, c - half);
		}
	}
}
