package baekjoon.P1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 1916. 최소비용 구하기 - 골드 5
 * @author hoseong
 * @category 데이크스트라
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<int[]>> map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map.get(from).add(new int[] {to, cost});
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[from] = 0;
        q.add(new int[] {from, 0});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if (tmp[1] > dist[tmp[0]]) continue;

            for (int[] d : map.get(tmp[0])) {
                int cost = d[1] + dist[tmp[0]];

                if(dist[d[0]] > cost) {
                    dist[d[0]] = cost;
                    q.add(new int[] {d[0], cost});
                }
            }
        }

        System.out.println(dist[to]);
    }
}
