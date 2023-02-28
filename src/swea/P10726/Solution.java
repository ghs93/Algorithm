package swea.P10726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 10726. 이진수 표현
 * @author hoseong
 * @category 비트 연산
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());

            int N = (1 << Integer.parseInt(st.nextToken())) - 1;
            int M = Integer.parseInt(st.nextToken());

            int result = N & M;

            sb.append('#').append(test_case).append(' ').append(result == N ? "ON" : "OFF").append('\n');
        }

        System.out.println(sb);
    }
}
