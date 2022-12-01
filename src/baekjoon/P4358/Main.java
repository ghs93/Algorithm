package baekjoon.P4358;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 백준 4358. 생태학 - 실버 2
 * @author hoseong
 * @category 해시를 사용한 집합과 맵
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> map = new HashMap<>();
		int total = 0;
		
		while(br.ready()) {
			String str = br.readLine();
			total++;
			
			if(map.containsKey(str)) {
				map.put(str, map.get(str) + 1);
				
			} else {
				map.put(str, 1);
			}
		}
		
		int size = map.size();
		String[] keySet = map.keySet().toArray(new String[size]); 
		Arrays.sort(keySet);
		
		for (String key : keySet) {
			double avg = ((double)map.get(key) / total) * 100;
			System.out.printf("%s %.4f\n", key, avg);
		}
	}
}