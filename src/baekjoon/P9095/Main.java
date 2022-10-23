package baekjoon.P9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9095. 1, 2, 3 더하기 - 실버 3
 * @author hoseong
 * @category DP
 */
public class Main {
	static int N, count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			count = 0;

			perm(0);
			System.out.println(count);
		}
	}

	static void perm(int total) {
		if(total == N) {
			count++;
			return;
		}
		
		if(total > N) return;
		
		for (int i = 1; i < 4; i++) {
			perm(total + i);
		}
	}
}