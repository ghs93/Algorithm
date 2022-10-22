package baekjoon.P16916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 16916. 부분 문자열 - 브론즈 2
 * 라빈-카프 알고리즘 사용
 * @author hoseong
 * @category 문자열
 */
public class Main_라빈카프 {
	static final int MOD = 1000003; //소수
	
	static String S, P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		P = br.readLine();
		
		if(P.length() > S.length()) {
			System.out.println(0);
			
		} else {
			System.out.println(findPattern());
		}
	}

	static int findPattern() {
		int sHash = 0, pHash = 0;
		int hashIdx = 10, hIdx = 1;
		
		//초기 hash값 셋팅
		for (int i = P.length() - 1; i >= 0; i--) {
			sHash = (sHash + (S.charAt(i) * hIdx)) % MOD;
			pHash = (pHash + (P.charAt(i) * hIdx)) % MOD;
			
			if(i != 0)
				hIdx = (hIdx * hashIdx) % MOD;
		}
		
		if(sHash == pHash && check(0)) return 1;
		
		//hash값 변경하며 비교
		int pSize = P.length();
		for (int i = pSize, size = S.length(); i < size; i++) {
			sHash = (sHash - S.charAt(i-pSize)*hIdx % MOD);
			sHash = (sHash + MOD) % MOD; //음수 방지
			sHash = (sHash * hashIdx + S.charAt(i)) % MOD;
			
			if(sHash == pHash && check(i-pSize+1)) {
				return 1;
			}
		}
		
		return 0;
	}
	
	static boolean check(int s) {
		int ln = P.length();
		
		for (int i = s; i < s+ln; i++) {
			if(S.charAt(i) != P.charAt(i - s)) {
				return false;
			}
		}
		
		return true;
	}
}
