package swea.P17675;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static class Manito implements Comparable<Manito> {
        int to, pay;

        public Manito(int to, int pay) {
            this.to = to;
            this.pay = pay;
        }

        @Override
        public int compareTo(Manito o) {
            return this.pay - o.pay;
        }
    }

    static int N, M;
    static ArrayList<Manito>[] arr;
    static long min;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new ArrayList[N+1];
            min = Long.MAX_VALUE;

            for (int i = 0; i <= N; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                arr[x].add(new Manito(y, c));
            }

            for (int i = 1; i <= N; i++) {
                min = Math.min(min, dijkstra(i));
            }

            if (min == Long.MAX_VALUE) min = -1;

            sb.append('#').append(test_case).append(' ').append(min).append('\n');
        }

        System.out.println(sb);
    }

    public static long dijkstra(int cur) {
        PriorityQueue<Manito> pq = new PriorityQueue<>();
        long[] dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        pq.add(new Manito(cur, 0));
        while (!pq.isEmpty()) {
            Manito tmp = pq.poll();

            for (Manito manito : arr[tmp.to]) {
                int cost = tmp.pay + manito.pay;
                if (dist[manito.to] > cost) {
                    dist[manito.to] = cost;
                    pq.add(new Manito(manito.to, cost));
                }
            }
        }

        return dist[cur];
    }
}