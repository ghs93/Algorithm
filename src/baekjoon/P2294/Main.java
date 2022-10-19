package baekjoon.P2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 2294. 동전 2 - 골드 5
 * @author hoseong
 * @category 
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //동전 종류
		int K = Integer.parseInt(st.nextToken()); //가치의 합
		
		List<Integer> coin = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			coin.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(coin, Collections.reverseOrder());
		
		int min = 100001;
		for (int i = 0; i < N; i++) {
			int temp = K, sum = 0;
			for (int j = i; j < N; j++) {
				int big = coin.get(j);
				
				sum += temp / big;
				temp %= big;
			}
			
			min = Math.min(min, sum);
		}

		System.out.println(min == 100001 ? -1 : min);
	}

}
