package baekjoon.P11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11054. 가장 긴 바이토닉 부분 수열 - 골드 4
 * @author hoseong
 * @category DP
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] LIS = new int[N];
		int[] LDS = new int[N];
		
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
			
			for (int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
			
			int k = N-i-1;
			LDS[k] = 1;
			for (int j = N-1; j > k; j--) {
				if(arr[k] > arr[j] && LDS[k] < LDS[j] + 1) {
					LDS[k] = LDS[j] + 1;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, LIS[i] + LDS[i]);
		}
		
		System.out.println(max-1);
	}

}
