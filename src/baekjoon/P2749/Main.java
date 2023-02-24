package baekjoon.P2749;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2749. 피보나치 수 3 - 골드 2
 * @author hoseong
 * @category 분할 정복을 이용한 거듭제곱
 */
public class Main {
    static long[][] matrix = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long[][] result = pow(N-1);
        System.out.println(result[0][0]);
    }

    static long[][] pow(long size) {
        if(size == 1 || size == 0) {
            return matrix;
        }

        long[][] d = pow(size / 2);
        long[][] m = mul(d, d);

        if(size % 2 != 0) {
            m = mul(m, matrix);
        }

        return m;
    }

    static long[][] mul(long[][] src, long[][] dest) {
        long[][] mat = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    mat[i][j] += src[i][k] * dest[k][j];
                    mat[i][j] %= 1000000;
                }
            }
        }

        return mat;
    }
}
