package baekjoon.P11003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 11003. 최솟값 찾기 - 플래티넘 5
 * @author hoseong
 * @category 덱
 */
public class Main {
	static class Number {
		int num, pos;

		public Number(int num, int pos) {
			this.num = num;
			this.pos = pos;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		
		Deque<Number> window = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int ai = Integer.parseInt(st.nextToken());
			
			A[i] = ai;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if(!window.isEmpty() &&  i== window.peek().pos + L) {
				window.poll();
			}
			
			while(!window.isEmpty() && window.peekLast().num > A[i]) {
				window.pollLast();
			}
			
			window.add(new Number(A[i], i));
			sb.append(window.peek().num).append(' ');
		}
		
		System.out.println(sb);
	}
}