package baekjoon.P23802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 23802. 골뱅이 찍기 - 뒤집힌 ㄱ - 브론지 3
 * @author hoseong
 * @category 구현
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n*5; j++) {
				sb.append('@');
			}
			sb.append('\n');
		}
		
		for (int i = 0, size = (n*5)-n; i < size; i++) {
			for (int j = 0; j < n; j++) {
				sb.append('@');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}