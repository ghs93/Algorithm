package baekjoon.P1701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 1701. Cubeditor - 골드 3
 * @author hoseong
 * @category 문자열, KMP
 */
public class Main {
	static char[] S, P;
	static int[] pi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine().toCharArray();
		P = new char[S.length];
		pi = new int[S.length];

		int max = 0;
		for (int i = 0, size = S.length; i <size; i++) {
			P = Arrays.copyOfRange(S, i, size);
			max = Math.max(max, makePi(size - i));
		}
		
		System.out.println(max);
	}
	
	static int makePi(int ln) {
		int max = 0;
		for (int i = 1, j = 0; i < ln; i++) {
			while(j>0 && P[i] != P[j]) j = pi[j-1];
			
			if(P[i] == P[j]) pi[i] = ++j;
			else pi[i] = 0;
			
			max = Math.max(max, pi[i]);
		}
		
		return max;
	}
}
