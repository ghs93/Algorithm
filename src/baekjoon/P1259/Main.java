package baekjoon.P1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1259. 팰린드롬수 - 브론즈 1
 * @author hoseong
 * @category 문자열, 구현
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String input;
		StringBuilder result = new StringBuilder();
		while(!(input = br.readLine()).equals("0")) {
			StringBuilder revInput = new StringBuilder(input);
			result.append(revInput.reverse().toString().equals(input) ? "yes" : "no").append('\n');
		}
		
		System.out.println(result);
	}

}
