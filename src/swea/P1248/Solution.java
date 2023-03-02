package swea.P1248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA 1248. 공통조상
 * @author hoseong
 * @category 트리, BFS
 */
public class Solution {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++)
        {
            sb.append('#').append(test_case).append(' ');
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int N1 = Integer.parseInt(st.nextToken());
            int N2 = Integer.parseInt(st.nextToken());

            int[] in = new int[V+1];
            ArrayList<Integer>[] arr = new ArrayList[V+1];
            for (int i = 0; i <= V; i++) {
                arr[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < E; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                in[to] = from;
                arr[from].add(to);
            }

            boolean[] visited = new boolean[V+1];
            int p = in[N1];
            while (p != 0) {
                visited[p] = true;
                p = in[p];
            }

            int parent = 0;
            p = in[N2];
            while (p != 0) {
                if (visited[p]) {
                    parent = p;
                    break;
                }

                p = in[p];
            }

            sb.append(parent).append(' ');

            Queue<Integer> q = new ArrayDeque<>(arr[parent]);
            int cnt = 1;
            while (!q.isEmpty()) {
                int to = q.poll();
                cnt++;

                q.addAll(arr[to]);
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}
