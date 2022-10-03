package baekjoon.P10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 백준 10845. 큐 - 실버 4
 * 
 * @author hoseong
 * @category 자료구조, 큐
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Deque<Integer> q = new ArrayDeque<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String str = st.nextToken();
			switch (str) {
			case "push":
				int p = Integer.parseInt(st.nextToken());
				q.add(p);
				break;
				
			case "pop":
				System.out.println(q.isEmpty() ? -1 : q.pop());
				break;
				
			case "size":
				System.out.println(q.size());
				break;
				
			case "empty":
				System.out.println(q.isEmpty() ? 1 : 0);
				break;
				
			case "front":
				System.out.println(q.isEmpty() ? -1 : q.peekFirst());
				break;
				
			case "back":
				System.out.println(q.isEmpty() ? -1 : q.peekLast());
				break;
			}
		}
	}
}