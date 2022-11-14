package baekjoon.P5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 백준 5430. AC - 골드 5
 * @author hoseong
 * @category Deque
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		tc: for (int tc = 0; tc < T; tc++) {
			char[] rd = br.readLine().toCharArray();
			
			int n = Integer.parseInt(br.readLine());
			ArrayDeque<Integer> arr = new ArrayDeque<>();
			
			st = new StringTokenizer(br.readLine(), "[|]|,");
			for (int i = 0; i < n; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean isReverse = false;
			for (int i = 0, size = rd.length; i < size; i++) {
				char p = rd[i];
				int cnt = 1;
				
				i += 1;
				while(i < size && p == rd[i]) {
					i++;
					cnt++;
				}
				i--;
				if(p == 'R') {
					if(cnt % 2 != 0)
						isReverse = !isReverse;
					
				} else {
					if(cnt > arr.size()) {
						arr.clear();
						sb.append("error").append('\n');
						continue tc;
						
					} else {
						for (int d = 0; d < cnt; d++) {
							if(isReverse) {
								arr.pollLast();
								
							} else {
								arr.pollFirst();
							}
						}
					}
				}
			}
			
			if(!arr.isEmpty()) {
				sb.append('[');
				for (int i = 0, size = arr.size(); i < size; i++) {
					if(isReverse) {
						sb.append(arr.pollLast()).append(',');
						
					} else {
						sb.append(arr.pollFirst()).append(',');
					}
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append(']').append('\n');
				
			} else {
				sb.append("[]\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}