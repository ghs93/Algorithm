package baekjoon.P11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 11053. 가장 긴 증가하는 부분 수열 - 실버 2
 *  DP 이진 검색 사용
 * @author hoseong
 * @category DP
 */
public class Main_DP2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] LIS = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int size = 0;
		for (int i = 0; i < N; i++) {
			int pos = Arrays.binarySearch(LIS, 0, size, arr[i]);
			if(pos >= 0) continue;
			
			int iPos = Math.abs(pos) - 1;
			LIS[iPos] = arr[i];
			
			if(iPos == size) size++;
		}
		
		System.out.println(size);
	}
}