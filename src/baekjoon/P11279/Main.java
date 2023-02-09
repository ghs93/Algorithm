package baekjoon.P11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 백준 11279. 최대 힙 - 실버 2
 * @author hoseong
 * @category 우선순위 큐
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');

            } else {
                pq.add(num);
            }
        }

        System.out.println(sb);
    }
}
