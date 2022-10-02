package baekjoon.P2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2920. 음계 - 브론즈 2
 * @author hoseong
 * @category 구현
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String asc = "1 2 3 4 5 6 7 8";
		String desc = "8 7 6 5 4 3 2 1";
		
		if(input.equals(asc))
			System.out.println("ascending");
		else if (input.equals(desc))
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
