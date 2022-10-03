package baekjoon.P1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1920. 수 찾기 - 실버 4
 * @author hoseong
 * @category 이분탐색
 */
public class Main {
	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] S = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(find(S[i], 0, N-1)).append('\n');
		}
		
		System.out.println(sb);
	}
	
	private static int find(int f, int start, int end) {
		if(start <= end) {
			int mid = (start + end) / 2;
			
			if(f == A[mid])
				return 1;
			else if (f < A[mid])
				return find(f, start, mid-1);
			else
				return find(f, mid+1, end);
		}
		
		return 0;
	}
}