package baekjoon.P16916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 16916. 부분 문자열 - 브론즈 2
 * 보이어무어 알고리즘 사용 - 해당 문제 시간 초과 발생
 * @author hoseong
 * @category 문자열
 */
public class Main_보이어무어 {
	static char[] S, P;
	static int[] skip;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine().toCharArray();
		P = br.readLine().toCharArray();
		
		if(S.length < P.length) {
			System.out.println(0);
			
		} else {
			//skip 패턴 만들기
			skip = new int[26];
			Arrays.fill(skip, P.length);
			
			for (int i = 0, size = P.length - 1; i < size; i++) {
				skip[P[i] - 97] = size - i;
			}
			
			System.out.println(findPattern());
		}
	}

	static int findPattern() {
		int sPoint = P.length - 1;
		
		while(sPoint < S.length) {
			int sp = sPoint;
			int pp = P.length - 1;
			
			int correctCnt = 0;
			while(pp >= 0) {
				if(S[sp] == P[pp]) {
					sp--;
					pp--;
					correctCnt++;
					
				} else {
					break;
				}
			}
			
			if(pp < 0) return 1;
			
			sPoint += skip[S[sp] - 97] - correctCnt;
		}
		
		return 0;
	}
}
