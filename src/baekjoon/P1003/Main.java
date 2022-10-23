package baekjoon.P1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1003. 피보나치 함수 - 실버 3
 * @author hoseong
 * @category DP
 */
public class Main {
	static int fi[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			fi = new int[N+1];
			
			fibo(N);
			if(N == 0)
				System.out.println("1 0");
			else
				System.out.println(fi[N-1] + " " + fi[N]);
		}
	}

	static int fibo(int n) {
		if(n < 2) return fi[n] = n;
		
		if(fi[n] > 0) return fi[n];
		
		return fi[n] = fibo(n-1) + fibo(n-2);
	}
}
