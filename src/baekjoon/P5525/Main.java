package baekjoon.P5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 5525. IOIOI - 실버 1
 * @author hoseong
 * @category 문자열
 */
public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0;
        int result = 0;
        for (int i = 1; i < M-1; i++) {
            if(S.charAt(i-1) == 'I' && S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
                count++;

                if(count == N) {
                    count--;
                    result++;
                }

                i++;

            } else {
                count = 0;
            }
        }

        System.out.println(result);
    }
}