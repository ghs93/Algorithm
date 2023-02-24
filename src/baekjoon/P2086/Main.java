package baekjoon.P2086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2086. 피보나치 수의 합 - 골드 1
 * @author hoseong
 * @category 분할 정복을 이용한 거듭제곱
 */
public class Main {
    static long[][] matrix = {{1, 1}, {1, 0}};
    static final int DIV = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        //F(a to b) = F(b+2) - F(a+1)
        long[][] aMat = pow(a);
        long[][] bMat = pow(b + 1);
        System.out.println((bMat[0][0] - aMat[0][0] + DIV) % DIV);
    }

    static long[][] pow(long size) {
        if(size == 0 || size == 1) {
            return matrix;
        }

        long[][] d = pow(size / 2);
        long[][] mat = mul(d, d);

        if(size % 2 != 0)
            mat = mul(mat, matrix);

        return mat;
    }

    static long[][] mul(long[][] src, long[][] dest) {
        long[][] mat = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    mat[i][j] += src[i][k] * dest[k][j];
                    mat[i][j] %= DIV;
                }
            }
        }

        return mat;
    }
}
