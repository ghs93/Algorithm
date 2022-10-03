package baekjoon.P1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1654. 랜선 자르기 - 실버 2
 * 
 * @author hoseong
 * @category 이분탐색, 매개 변수 탐색
 */
public class Main {
	static long[] arr;
	static int K, N;
	static long max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new long[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);
		
		getMax(0, arr[K-1] * 2);
		System.out.println(max);
	}

	private static void getMax(long start, long end) {
		if(start <= end) {
			long mid = (start + end) / 2;
			long cnt = 0;
			
			for (int i = 0; i < K; i++) {
				cnt += arr[i] / mid;
			}
			
			if(cnt < N) {
				getMax(start, mid-1);
				
			} else {
				max = Math.max(max, mid);
				getMax(mid+1, end);
			}
		}
	}
}