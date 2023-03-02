package swea.P1231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 1231. 중위순회
 * @author hoseong
 * @category 트리, DFS
 */
public class Solution {
    static int N;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 1; test_case <= 10; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            arr = new char[N + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int m = Integer.parseInt(st.nextToken());
                arr[m] = st.nextToken().charAt(0);
            }

            sb.append('#').append(test_case).append(' ');
            dfs(1);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int idx) {
        if (idx > N) return;

        dfs(idx * 2);
        sb.append(arr[idx]);
        dfs(idx*2 + 1);
    }
}
