package baekjoon.P1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 백준 1764. 듣보잡 - 실버 4
 * @author hoseong
 * @category 집합, 정렬
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> deud = new HashSet<>();
        for (int i = 0; i < N; i++) {
            deud.add(br.readLine());
        }

        PriorityQueue<String> q = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            String bo = br.readLine();
            if(deud.contains(bo))
                q.add(bo);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(q.size()).append('\n');
        while (!q.isEmpty())
            sb.append(q.poll()).append('\n');

        System.out.println(sb);
    }
}