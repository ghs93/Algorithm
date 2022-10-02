package baekjoon.P1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 백준 1181. 단어 정렬 - 실버 5
 * @author hoseong
 * @category 문자열, 정렬
 */
public class Main {
	static class Word implements Comparable<Word> {
		String str;
		int size;

		public Word(String str, int size) {
			this.str = str;
			this.size = size;
		}

		@Override
		public int compareTo(Word o) {
			if(this.size == o.size) {
				return this.str.compareTo(o.str);
				
			} else {
				return this.size - o.size;
			}
		}

		@Override
		public boolean equals(Object obj) {
			Word w = (Word)obj;
			
			return this.str.equals(w.str);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Word> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			Word word = new Word(str, str.length());
			
			if(!list.contains(word))
				list.add(word);
		}
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (Word word : list) {
			sb.append(word.str).append('\n');
		}
		
		System.out.println(sb);
	}

}
