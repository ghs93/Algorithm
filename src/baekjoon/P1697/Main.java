package baekjoon.P1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1697. 숨바꼭질 - 실버 1
 * @author hoseong
 * @category BFS
 */
public class Main {
    final static int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N >= K) {
            System.out.println(N - K);
            return;
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[MAX];

        q.add(new int[] {N, 0});
        visited[N] = true;

        while (!q.isEmpty()) {
            int[] jump = q.poll();

            if(jump[0] == K) {
                System.out.println(jump[1]);
                break;
            }

            if(jump[0] < K) {
                int add = jump[0] + 1;
                int warp = jump[0] * 2;
                if(add < MAX && !visited[add]) {
                    q.add(new int[] {add, jump[1] + 1});
                    visited[add] = true;
                }

                if(warp < MAX && !visited[warp]) {
                    q.add(new int[] {warp, jump[1] + 1});
                    visited[warp] = true;
                }
            }

            int back = jump[0] - 1;
            if(back >= 0 && !visited[back]) {
                q.add(new int[] {back, jump[1] + 1});
                visited[back] = true;
            }
        }
    }
}
