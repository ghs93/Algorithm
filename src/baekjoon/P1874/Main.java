package baekjoon.P1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 백준 1874. 스택 수열 - 실버 2
 * @author hoseong
 * @category 스택
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		int[] input = new int[N+1];
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		int[] output = new int[N+1];
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> s = new ArrayList<>();
		int start = 1;
		for (int i = 1; i <= N; i++) {
			for (; start <= N; start++) {
				if(start == i) {
					s.add(0);
					output[i] = start;
				} else {
					s.add(1);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(input[i] != output[i]) {
				System.out.println("NO");
				return;
			}
		}
		
		for (Integer integer : s) {
			if(integer == 0)
				System.out.println("-");
			else
				System.out.println("+");
		}
	}

}
