package baekjoon.P1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1676. 팩토리얼 0의 개수 - 실버 5
 * @author hoseong
 * @category 수학
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int total = 1;
        for (int i = N; i > 0; i--) {
            total *= i;

            while (total % 10 == 0) {
                total /= 10;
                cnt++;
            }

            total %= 1000;
        }

        System.out.println(total);
        System.out.println(cnt);
    }
}
