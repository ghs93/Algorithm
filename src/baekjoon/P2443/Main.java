package baekjoon.P2443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2443. 별 찍기 - 6 - 브론즈 3
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

            for (int j = 0; j < (2*i)-1; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
