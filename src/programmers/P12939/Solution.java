package programmers.P12939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Programmers 12939. 최댓값과 최솟값
 * @author hoseong
 * @category MIN, MAX
 */
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(solution(br.readLine()));
	}

	public static String solution(String s) {
		StringTokenizer st = new StringTokenizer(s);
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		while(st.hasMoreTokens()) {
			int m = Integer.parseInt(st.nextToken());
			
			min = Math.min(min, m);
			max = Math.max(max, m);
		}
		
        return min + " " + max;
    }
}
