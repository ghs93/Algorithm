package baekjoon.P11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 11779. 최소비용 구하기 2 - 골드 3
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Node>[] nodes = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[from].add(new Node(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> q = new PriorityQueue<>();
        int[] D = new int[N+1];
        int[] in = new int[N+1];
        Arrays.fill(D, Integer.MAX_VALUE);

        q.add(new Node(start, 0));
        D[start] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.to == end) break;
            if (D[node.to] < node.weight) continue;

            for (Node n : nodes[node.to]) {
                int cost = D[node.to] + n.weight;

                if (D[n.to] > cost) {
                    in[n.to] = node.to;

                    D[n.to] = cost;
                    q.add(new Node(n.to, cost));
                }
            }
        }

        int path = end;
        int cnt = 0;
        LinkedList<Integer> list = new LinkedList<>();
        while (path != 0) {
            list.add(path);
            cnt++;
            path = in[path];
        }

        StringBuilder sb = new StringBuilder();
        Collections.reverse(list);
        for (int l : list)
            sb.append(l).append(' ');

        System.out.println(D[end]);
        System.out.println(cnt);
        System.out.println(sb);
    }
}
