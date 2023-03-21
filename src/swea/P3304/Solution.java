package swea.P3304;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 3304. 최장 공통 부분 수열
 * @author hoseong
 * @category DP, LCS
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');
            st = new StringTokenizer(br.readLine());

            char[] src = st.nextToken().toCharArray();
            char[] dest = st.nextToken().toCharArray();

            int srcLength = src.length;
            int destLength = dest.length;
            int[][] dp = new int[srcLength+1][destLength+1];

            for (int i = 1; i <= srcLength; i++) {
                for (int j = 1; j <= destLength; j++) {
                    if (src[i-1] == dest[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                    else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

            sb.append(dp[srcLength][destLength]).append('\n');
        }

        System.out.println(sb);
    }
}
