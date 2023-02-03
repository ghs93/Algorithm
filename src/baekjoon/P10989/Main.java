package baekjoon.P10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 10989. 수 정렬하기 - 브론즈 1
 * @author hoseong
 * @category 정렬
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        int min = 10001;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            arr[num]++;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int num = 0;
        for (int i = min; i <= max; i++) {
            num = arr[i];
            for (int j = 0; j < num; j++) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);
    }
}
