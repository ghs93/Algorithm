package swea.P2948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * SWEA 2948. 문자열 교집합
 * @author hoseong
 * @category HashSet
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append('#').append(test_case).append(' ');

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            HashSet<String> set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                set.add(st.nextToken());
            }

            int result = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                if (set.contains(st.nextToken()))
                    result++;
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}
