package baekjoon.P10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 10814. 나이순 정렬 - 실버 5
 * @author hoseong
 * @category 정렬
 */
public class Main {
	static class Member {
		int age;
		String name;
		
		public Member(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return age + " " + name + "\n";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Member>[] members = new ArrayList[201];
		for (int i = 0; i <= 200; i++) {
			members[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Member m = new Member(age, name);
			
			members[age].add(m);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 200; i++) {
			if(!members[i].isEmpty()) {
				for (Member m : members[i]) {
					sb.append(m.toString());
				}
			}
		}
		
		System.out.println(sb);
	}

}
