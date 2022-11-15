package baekjoon.P1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 백준 1620. 나는야 포켓몬 마스터 이다솜 - 실버 4
 * @author hoseong
 * @category 해시를 사용한 집합과 맵
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> numToName = new HashMap<>();
		HashMap<String, Integer> nameToNum = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String n = br.readLine();
			numToName.put(i, n);
			nameToNum.put(n, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String m = br.readLine();
			
			if(m.charAt(0) - 65 < 0) { //숫자로 이름찾기
				sb.append(numToName.get(Integer.parseInt(m))).append('\n');
				
			} else { //이름으로 숫자찾기
				sb.append(nameToNum.get(m)).append('\n');
			}
		}
		
		System.out.println(sb);
	}
}