package baekjoon.P15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 15649. N과 M(1) - 실버 3
 * @author hoseong
 * @category 백 트래킹
 */
public class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];

        perm(0, new int[m]);

        System.out.println(sb);
    }

    static void perm(int cnt, int[] arr) {
        if (cnt == m) {
            for (int idx : arr) {
                sb.append(idx).append(' ');
            }
            sb.append('\n');

            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            arr[cnt] = i;
            perm(cnt+1, arr);

            visited[i] = false;
        }
    }
}
