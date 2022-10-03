package baekjoon.P11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11866. 요세푸스 문제 0 - 실버 5
 * 
 * @author hoseong
 * @category 구현, 큐
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		
		int k = 1;
		for (int i = 1; i <= N; i++) {
			int idx = 0;
			
			while(idx<K) {
				if(arr[k % (N+1)] > 0) {
					k %= (N+1);
					idx++;
				}
				
				k++;
			}
			
			sb.append(arr[--k]).append(", ");
			arr[k] = 0;
		}
		
		sb.delete(sb.length()-2, sb.length());
		sb.append('>');
		
		System.out.println(sb);
	}

}
