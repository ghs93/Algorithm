package baekjoon.P1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1629. 곱셈 - 실버 1
 * @author hoseong
 * @category 분할 정복을 이용한 거듭제곱
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(calc(A, B, C));
    }

    public static long calc(int a, int b, int c) {
        if(b == 1)
            return a % c;

        long half = calc(a, b/2, c);

        if(b % 2 == 0)
            return half * half % c;
        else
            return half * half % c * a % c;
    }
}
