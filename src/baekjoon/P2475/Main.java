package baekjoon.P2475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2475. 검증수 - 브론즈 5
 * @author hoseong
 * @category 구현, 사칙연산
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += (int)Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		
		System.out.println(sum%10);
	}
}