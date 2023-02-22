package baekjoon.P9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9663. N-Queen - 골드 4
 * @author hoseong
 * @category DFS, 백트래킹
 */
public class Main {
    static int N;
    static int result;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new int[N];

        dfs(0);
        System.out.println(result);
    }

    static void dfs(int cnt) {
        if(cnt == N) {
            result++;
            return;
        }

        loop: for (int i = 0; i < N; i++) {
            for (int j = 0; j < cnt; j++) {
                if (visited[j] == i) continue loop;
                else if (Math.abs(cnt - j) == Math.abs(visited[j] - i)) continue loop;
            }

            visited[cnt] = i;
            dfs(cnt + 1);
        }
    }
}
