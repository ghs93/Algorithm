package baekjoon.P2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2606. 바이러스 - 실버 3
 * @author hoseong
 * @category BFS
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] computers = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            computers[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            computers[from].add(to);
            computers[to].add(from);
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];

        q.add(1);
        visited[1] = true;

        int virus = -1;
        while (!q.isEmpty()) {
            int com = q.poll();
            virus++;

            for (int c : computers[com]) {
                if(visited[c]) continue;

                visited[c] = true;
                q.add(c);
            }
        }

        System.out.println(virus);
    }
}
