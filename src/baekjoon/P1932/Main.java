package baekjoon.P1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1932 정수 삼각형 - 실버 1
 * @author hoseong
 * @category
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = N; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                int a = arr[i-1][j] + arr[i][j];
                int b = arr[i-1][j] + arr[i][j+1];

                arr[i-1][j] = Math.max(a, b);
            }
        }

        System.out.println(arr[1][1]);
    }
}
