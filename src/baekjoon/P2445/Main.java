package baekjoon.P2445;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2445. 별 찍기 - 8 - 브론즈 3
 * @author hoseong
 * @category 구현
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                sb.append('*');
            }

            for (int j = 0; j < 2*(N-i); j++) {
                sb.append(' ');
            }

            for (int j = 0; j < i; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        for (int i = N-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                sb.append('*');
            }

            for (int j = 0; j < 2*(N-i); j++) {
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