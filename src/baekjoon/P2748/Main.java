package baekjoon.P2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2748. 피보나치 수 2 - 브론즈 1
 * @author hoseong
 * @category 수학, DP
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long fibo = N;
        long before = 0;
        long current = 1;
        for (int i = 2; i <= N; i++) {
            fibo = before + current;
            before = current;
            current = fibo;
        }

        System.out.println(fibo);
    }
}
