package baekjoon.P1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1912. 연속합 - 실버 2
 * @author hoseong
 * @category DP
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        int tmp = arr[0];
        for (int i = 1; i < N; i++) {
            tmp += arr[i];

            if (tmp < arr[i]) tmp = arr[i];

            if (tmp > max) max = tmp;
        }

        System.out.println(max);
    }
}
