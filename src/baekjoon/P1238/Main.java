package baekjoon.P1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 1238. 파티 - 골드 3
 * @author hoseong
 * @category 데이크스트라
 */
public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int[] go;
    static int[] back;
    static int N, M, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] map = new ArrayList[N+1];
        ArrayList<Node>[] revMap = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            map[i] = new ArrayList<>();
            revMap[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[from].add(new Node(to, weight));
            revMap[to].add(new Node(from, weight));
        }

        go = dijkstra(map);
        back = dijkstra(revMap);

        int result = 0;
        for (int i = 1; i < N+1; i++) {
            if (i == X) continue;

            result = Math.max(result, go[i] + back[i]);
        }

        System.out.println(result);
    }

    static int[] dijkstra(ArrayList<Node>[] road) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] d = new int[N+1];
        Arrays.fill(d, Integer.MAX_VALUE);

        q.add(new Node(X, 0));
        d[X] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.weight > d[node.to]) continue;

            for (Node n : road[node.to]) {
                int cost = d[node.to] + n.weight;

                if (d[n.to] > cost) {
                    d[n.to] = cost;
                    q.add(new Node(n.to, cost));
                }
            }
        }

        return d;
    }
}
