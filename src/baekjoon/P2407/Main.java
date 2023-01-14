package baekjoon.P2407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 백준 2407. 조합 - 실버 3
 * @author hoseong
 * @category 조합론, 큰 수 연산
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        for (int i = 0; i < m; i++) {
            a = a.multiply(BigInteger.valueOf(n-i));
            b = b.multiply(BigInteger.valueOf(m-i));
        }

        System.out.println(a.divide(b));
    }
}
