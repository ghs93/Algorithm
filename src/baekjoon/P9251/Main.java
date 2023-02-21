package baekjoon.P9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9521. LCS - 골드 5
 * @author hoseong
 * @category LCS, DP
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] nArr = br.readLine().toCharArray();
        char[] mArr = br.readLine().toCharArray();

        int n = nArr.length;
        int m = mArr.length;
        int[][] lcs =  new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(nArr[i-1] == mArr[j-1]) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;

                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        System.out.println(lcs[n][m]);
    }
}
