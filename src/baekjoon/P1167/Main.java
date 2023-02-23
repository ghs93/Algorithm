package baekjoon.P1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 1167. 트리의 지름 - 골드 2
 * @author hoseong
 * @category DFS
 */
public class Main {
    static int V;
    static int max = Integer.MIN_VALUE, leaf;
    static ArrayList<int[]>[] tree;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V+1];
        
        for (int i = 0; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int to = Integer.parseInt(st.nextToken());

                if(to == -1) break;

                int weight = Integer.parseInt(st.nextToken());
                tree[from].add(new int[] {to, weight});
            }
        }

        visited = new boolean[V+1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[V+1];
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
