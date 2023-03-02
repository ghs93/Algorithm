package baekjoon.P2441;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2441. 별 찍기 - 4 - 브론즈 3
 * @author hoseong
 * @category 구현
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = N; i > 0; i--) {
            for (int j = 0; j < N-i; j++) {
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
