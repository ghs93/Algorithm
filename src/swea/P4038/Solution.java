package swea.P4038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 4038. 단어가 등장하는 횟수
 * @author hoseong
 * @category 문자열, Hash
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append('#').append(test_case).append(' ');

            String B = br.readLine();
            String S = br.readLine();

            sb.append(findPattern(B, S)).append('\n');
        }

        System.out.println(sb);
    }

    static public int findPattern(String B, String S) {
        int result = 0;

        int bLength = B.length();
        int sLength = S.length();

        long bHash = 0;
        long sHash = 0;

        int base = 313;
        long mul = 1;

        for (int i = 0; i <= bLength - sLength; i++) {
            if (i == 0) {
                for (int j = 0; j < sLength; j++) {
                    bHash += B.charAt(sLength - 1 - j) * mul;
                    sHash += S.charAt(sLength - 1 - j) * mul;

                    if (j < sLength - 1) {
                        mul *= base;
                    }
                }
                
            } else {
                bHash = base * (bHash - (B.charAt(i - 1) * mul)) + B.charAt(sLength - 1 + i);
            }

            if (bHash == sHash) result++;
        }

        return result;
    }
}
