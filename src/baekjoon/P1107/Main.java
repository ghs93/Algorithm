package baekjoon.P1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 백준 1107. 리모컨 - 골드 5
 * @author hoseong
 * @category 조합
 */
public class Main {
	static char[] targetC;
	static HashSet<Integer> set;
	static int result, min = Integer.MAX_VALUE, target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		target = Integer.parseInt(br.readLine());
		targetC = String.valueOf(target).toCharArray();

		int N = Integer.parseInt(br.readLine());
		set = new HashSet<>();

		if(N != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
		}
		
		if(N == 10) {
			System.out.println(Math.abs(100 - target));
			return;
		}
		
		for (int i = -1; i < 2; i++) {
			int n = targetC.length + i;
			
			if(n <= 0) continue;
			comb(0, n, 0);
		}
		
		int termTo100 = Math.abs(100 - target);
		int termToRemote = Math.abs(target - result);
		int length = result == 0 ? 1 : 0;
		
		while(result > 0) {
			result /= 10;
			length++;
		}
		
		if (termTo100 < termToRemote + length) {
			System.out.println(termTo100);

		} else {
			System.out.println(termToRemote + length);
		}
	}

	public static void comb(int cnt, int n, int sum) {
		if(cnt == n) {
			int term = Math.abs(target - sum);
			
			if (term < min) {
				min = term;
				result = sum;
			}
			
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(set.contains(i)) continue;
			
			comb(cnt+1, n, (sum * 10) + i);
		}
	}
}
