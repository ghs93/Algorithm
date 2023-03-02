package baekjoon.P2444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2444. 별 찍기 - 7 - 브론즈 3
 * @author hoseong
 * @category 구현
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = N; i > 0; i--) {
            for (int j = 0; j < i-1; j++) {
                sb.append(' ');
            }

            int n = N-i+1;
            for (int j = 0; j < (2*n)-1; j++) {
                sb.append('*');
            }
            sb.append('\n');
        }

        for (int i = N-1; i > 0; i--) {
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