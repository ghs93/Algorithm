package baekjoon.P16916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 16916. 부분 문자열 - 브론즈 2
 * KMP 알고리즘 사용
 * @author hoseong
 * @category 문자열
 */
public class Main_KMP {
	static char[] S, P;
	static int[] pi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine().toCharArray();
		P = br.readLine().toCharArray();
		
		if(S.length < P.length) {
			System.out.println(0);
			
		} else {
			//패턴의 부분일치 테이블
			pi = new int[P.length];
			makePi();
			
			System.out.println(findPattern());
		}
	}

	//부분일치 테이블 만들기
	static void makePi() {
		for (int i = 1, j=0, size = pi.length; i < size; i++) {
			while(j>0 && P[i] != P[j]) j = pi[j-1];
			
			if(P[i] == P[j]) pi[i] = ++j;
			else pi[i] = 0;
		}
	}
	
	static int findPattern() {
		for (int i = 0, j = 0, sSize = S.length; i < sSize; i++) {
			while(j>0 && S[i] != P[j]) j = pi[j-1];
			
			if(S[i] == P[j]) {
				if(j == P.length - 1) {
					return 1;
					
				} else {
					j++;
				}
			}
		}
		
		return 0;
	}
}
