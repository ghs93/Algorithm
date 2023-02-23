package baekjoon.P1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 1967. 트리의 지름 - 골드 4
 * @author hoseong
 * @category DFS
 */
public class Main {
    static int N;
    static int max = Integer.MIN_VALUE, leaf;
    static ArrayList<int[]>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[from].add(new int[] {to, weight});
            tree[to].add(new int[] {from, weight});
        }

        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[N+1];
        visited[leaf] = true;
        dfs(leaf, 0);

        System.out.println(max);
    }

    static void dfs(int cur, int sum) {
        boolean end = true;

        for(int[] t : tree[cur]) {
            if(visited[t[0]]) continue;

            end = false;
            visited[t[0]] = true;
            dfs(t[0], sum + t[1]);
        }

        if(end) {
            if(sum > max) {
                max = sum;
                leaf = cur;
            }
        }
    }
}
