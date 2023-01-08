package baekjoon.P15903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 15903. 키드 합체 놀이 - 실버 1
 * @author hoseong
 * @category 우선순위 큐
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            long c1 = pq.poll();
            long c2 = pq.poll();

            pq.add(c1 + c2);
            pq.add(c1 + c2);
        }

        long sum = 0;
        while (!pq.isEmpty())
            sum += pq.poll();

        System.out.println(sum);
    }
}
