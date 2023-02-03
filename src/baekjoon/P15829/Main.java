package baekjoon.P15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 15829. Hashing - 브론즈 2
 * @author hoseong
 * @category 문자열, MOD
 */
public class Main {
    public static void main(String[] args) throws IOException {
        //a = 97
        // ...
        //z = 122
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int r = 31;
        int diff = 96;
        int mod = 1234567891;
        long result = 0;
        long pow = 1;
        for (int i = 0; i < L; i++) {
            int alpha = str.charAt(i) - diff;

            result += pow*alpha;
            pow = (pow*r) % mod;
        }

        System.out.println(result % mod);
    }
}
