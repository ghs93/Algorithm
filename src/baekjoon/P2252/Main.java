package baekjoon.P2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2252. 줄 세우기 - 골드 3
 * @author hoseong
 * @category 위상정렬
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N+1];
        int[] in = new int[N+1];

        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            arr[front].add(back);
            in[back]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (in[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int tmp = q.poll();

            sb.append(tmp).append(' ');
            for (int to : arr[tmp]) {
                in[to]--;

                if (in[to] == 0)
                    q.add(to);
            }
        }

        System.out.println(sb);
    }
}
