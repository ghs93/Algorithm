package swea.P4038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 4038. 단어가 등장하는 횟수
 * @author hoseong
 * @category 문자열, KMP
 */
public class Solution {
    static int[] pi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append('#').append(test_case).append(' ');

            char[] B = br.readLine().toCharArray();
            char[] S = br.readLine().toCharArray();

            if (B.length < S.length) {
                sb.append(0).append('\n');

            } else {
                pi = new int[S.length];
                makePi(S);

                sb.append(findPattern(B, S)).append('\n');
            }
        }

        System.out.println(sb);
    }

    static void makePi(char[] S) {
        for (int i = 1, j=0, size = S.length; i < size; i++) {
            while(j>0 && S[i] != S[j]) j = pi[j-1];

            if(S[i] == S[j]) pi[i] = ++j;
            else pi[i] = 0;
        }
    }

    static int findPattern(char[] B, char[] S) {
        int result = 0;

        for (int i = 0, j = 0, sSize = B.length; i < sSize; i++) {
            while(j>0 && B[i] != S[j]) j = pi[j-1];

            if(B[i] == S[j]) {
                if(j == S.length - 1) {
                    result++;
                    i = i - j + 1;
                    j = 0;

                } else {
                    j++;
                }
            }
        }

        return result;
    }
}
