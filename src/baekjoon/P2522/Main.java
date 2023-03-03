package baekjoon.P2522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2522. 별 찍기 - 12 - 브론즈 3
 * @author hoseong
 * @category 구현
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = N-i; j > 0; j--) {
                sb.append(' ');
            }

            for (int j = 0; j < i; j++) {
                sb.append('*');
            }

            sb.append('\n');
        }

        for (int i = N-1; i > 0; i--) {
            for (int j = N-i; j > 0; j--) {
                sb.append(' ');
            }

            for (int j = 0; j < i; j++) {
                sb.append('*');
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
