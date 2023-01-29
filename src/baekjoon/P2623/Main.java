package baekjoon.P2623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 2623. 음악프로그램 - 골드 3
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
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        int cnt = 0;
        int[] inDegree = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int size = Integer.parseInt(st.nextToken()) - 1;
            int before = Integer.parseInt(st.nextToken());

            for (int j = 0; j < size; j++) {
                int next = Integer.parseInt(st.nextToken());

                arr[before].add(next);
                before = next;

                if(inDegree[next] == 0)
                    cnt++;

                inDegree[next]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i] == 0)
                q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            for (int i = 0, size = q.size(); i < size; i++) {
                int target = q.poll();
                sb.append(target).append('\n');

                for(int next : arr[target]) {
                    if(--inDegree[next] == 0) {
                        q.add(next);
                        cnt--;
                    }
                }
            }
        }

        System.out.println(cnt == 0 ? sb : 0);
    }
}
