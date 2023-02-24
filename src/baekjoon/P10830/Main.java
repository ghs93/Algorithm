package baekjoon.P10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10830. 행렬 제곱 - 골드 4
 * @author hoseong
 * @category 분할 정복
 */
public class Main {
    static int[][] matrix;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = pow(matrix, B);

        StringBuilder sb = new StringBuilder();
        for (int[] mat : result) {
            for (int m : mat)
                sb.append(m % 1000).append(' ');
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static int[][] pow(int[][] mat, long size) {
        if(size == 1) {
            return mat;
        }

        int[][] d = pow(mat, size / 2);
        int[][] m = mul(d, d);

        if(size % 2 != 0) {
            m = mul(m, matrix);
        }

        return m;
    }

    static int[][] mul(int[][] src, int[][] dest) {
        int[][] mat = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    mat[i][j] += src[i][k] * dest[k][j];
                    mat[i][j] %= 1000;
                }
            }
        }

        return mat;
    }
}
