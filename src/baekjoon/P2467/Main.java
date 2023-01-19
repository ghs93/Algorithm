package baekjoon.P2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2467. 용액 - 골드 5
 * @author hoseong
 * @category 투 포인터
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int al = 0, san = n-1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int ec = Integer.parseInt(st.nextToken());

            arr[i] = ec;
        }

        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while(al < san) {
            int sum = arr[al] + arr[san];

            if(Math.abs(sum) < Math.abs(min)) {
                min = sum;
                left = al;
                right = san;
            }

            if(sum < 0)
                al++;
            else if(sum > 0)
                san--;
            else
                break;
        }

        System.out.println(arr[left] + " " + arr[right]);
    }
}
