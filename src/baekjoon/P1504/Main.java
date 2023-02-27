package baekjoon.P1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 1504. 특정한 최단 경로 - 골드 4
 * @author hoseong
 * @category 데이크스트라
 */
public class Main {
    static class Edge implements Comparable<Edge> {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static ArrayList<Edge>[] map;
    static int N;
    static int MAX = 200000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[from].add(new Edge(to, weight));
            map[to].add(new Edge(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int d1 = dijkstra(1)[v1] + dijkstra(v1)[v2] + dijkstra(v2)[N];
        int d2 = dijkstra(1)[v2] + dijkstra(v2)[v1] + dijkstra(v1)[N];

        int result = Math.min(d1, d2);
        System.out.println(result >= MAX ? -1 : result);
    }

    static int[] dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] d = new int[N+1];
        Arrays.fill(d, MAX);

        d[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (edge.weight > d[edge.to]) continue;

            for (Edge eg : map[edge.to]) {
                int cost = eg.weight + d[edge.to];

                if(d[eg.to] > cost) {
                    d[eg.to] = cost;
                    pq.add(new Edge(eg.to, cost));
                }
            }
        }

        return d;
    }
}
