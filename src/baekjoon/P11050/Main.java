package baekjoon.P11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11050. 이항 계수 1 - 브론즈 1
 * 
 * @author hoseong
 * @category 구현, 조합론
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(K == 0 || K == N) {
			System.out.println(1);
			
		} else if(K == 1 || K == (N-1)) {
			System.out.println(N);
			
		} else {
			int totalN = 1, totalK = 1;
			for (int i = 0; i < K; i++) {
				totalN *= N-i;
				totalK *= K-i;
			}
			
			System.out.println(totalN / totalK);
		}
	}
}