package baekjoon.P1509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 1509. 팰린드롬 분할 - 골드 1
 * @author hoseong
 * @category DP
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int length = str.length();

        char[] arr = new char[length+1];
        for (int i = 1; i <= length; i++) {
            arr[i] = str.charAt(i-1);
        }

        boolean[][] palindrome = new boolean[length+1][length+1];
        for (int i = 1; i <= length; i++) {
            palindrome[i][i] = true;

            if(i < length && arr[i] == arr[i+1])
                palindrome[i][i+1] = true;
        }

        for (int i = 2; i <= length; i++) {
            for (int j = 1; j + i <= length; j++) {
                if(arr[j] == arr[j+i] && palindrome[j+1][j+i-1])
                    palindrome[j][j+i] = true;
            }
        }

        int[] dp = new int[length+1];
        Arrays.fill(dp, length);
        dp[0] = 0;

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++) {
                if(palindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }

        System.out.println(dp[length]);
    }
}
