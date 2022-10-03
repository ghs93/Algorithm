package baekjoon.P2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2609. 최대공약수와 최소공배수 - 브론즈 1
 * @author hoseong
 * @category 유클리드 호제법
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int a = Math.max(A, B);
		int b = Math.min(A, B);
		
		int r = a % b;
		
		if(r == 0) {
			System.out.println(b);
			System.out.println(a);
			
		} else {
			int rp = b % r;
			
			while(rp > 0) {
				int temp = r;
				r = rp;
				rp = temp % rp;
			}
			
			System.out.println(r);
			System.out.println(r * (a / r) * (b / r));
		}
	}
}