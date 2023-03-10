package baekjoon.P13172;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 13172. Σ - 골드 4
 * @author hoseong
 * @category 정수론, 페르마의 소정리
 */
public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        long result = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            result += S * pow(N, MOD - 2) % MOD;
            result %= MOD;
        }

        System.out.println(result);
    }

    static long pow(int n, int size) {
        if (size == 1) return n;

        if (size % 2 == 1) {
            return n * pow(n, size - 1) % MOD;
        }

        long result = pow(n, size / 2);
        return result * result % MOD;
    }
}
