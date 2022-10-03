package baekjoon.P2751;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2751. 수 정렬하기 2 - 실버 5
 * @author hoseong
 * @category 정렬
 */
public class Main {

	/**
	 * counting sort 사용 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[2000001];
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[n + 1000000] = true;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 2000000; i++) {
			if(arr[i])
				sb.append(i - 1000000).append('\n');
		}
		
		System.out.println(sb);
	}
}