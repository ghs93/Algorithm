package programmers.P12951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Programmers 12951. JadenCase 문자열 만들기
 * @author hoseong
 * @category 
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println(solution(br.readLine()));
	}

	public static String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        
        while(st.hasMoreTokens()) {
        	String tmp = st.nextToken();
        	
        	sb.append(tmp.toUpperCase().charAt(0));
    		sb.append(tmp.toLowerCase().substring(1, tmp.length())).append(' ');
        }
        
        if(sb.length() == 0)
        	return "";
        else
        	return sb.deleteCharAt(sb.length()-1).toString();
    }
}
