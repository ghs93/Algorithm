package baekjoon.P3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 3273. 두 수의 합 - 실버 3
 * @author hoseong
 * @category 투 포인터
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int index = Integer.parseInt(br.readLine());
        int cnt = 0, left = 0, right = n-1;
        while(left < right) {
            int sum = arr[left] + arr[right];

            if (sum == index) {
                cnt++;
                left++;
                right--;

            } else if (sum > index) {
                right--;

            } else {
                left++;
            }
        }

        System.out.println(cnt);
    }
}
