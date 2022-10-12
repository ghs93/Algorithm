package swea.P5658;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * SWEA 5658. 보물상자 비밀번호 
 * @author hoseong
 * @category 문자열
 */
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int n = (N/4);
			String temp = br.readLine();
			String pw = temp + temp.substring(0, n-1);
			
			Set<String> exist = new HashSet<>();
			ArrayList<Integer> list = new ArrayList<>();
			
			for (int i = n, size = pw.length(); i <= size; i++) {
				String p = pw.substring(i-n, i);
				
				if(exist.add(p)) {
					list.add(Integer.parseInt(p, 16));
				}
			}
			
			Collections.sort(list, Collections.reverseOrder());
			System.out.println("#" + tc + " " + list.get(K-1));
		}
	}
}
