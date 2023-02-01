package baekjoon.P2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2805. 나무 자르기 - 실버 2
 * @author hoseong
 * @category 이분 탐색
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int min = 0;
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());

            arr[i] = tree;
            max = Math.max(max, tree);
        }

        int mid = 0;
        while (min < max) {
            mid = (max + min) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if(arr[i] > mid)
                    sum += arr[i] - mid;
            }

            if(sum >= M)
                min = mid + 1;
            else
                max = mid;
        }

        System.out.println(min - 1);
    }
}
