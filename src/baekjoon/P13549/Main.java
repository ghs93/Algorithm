package baekjoon.P13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 13549. 숨바꼭질 3 - 골드 5
 * @author hoseong
 * @category BFS
 */
public class Main {
    static int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N >= M) {
            System.out.println(N - M);
            return;
        }

        Queue<int[]> q = new ArrayDeque<>();
        int[] visited = new int[MAX];

        q.add(new int[] {N, 1});
        visited[N] = 1;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            int go = tmp[0] + 1;
            int back = tmp[0] - 1;
            int jump = tmp[0] * 2;

            if(jump < MAX && (visited[jump] == 0 || visited[jump] > tmp[1])) {
                visited[jump] = tmp[1];
                q.add(new int[] {jump, tmp[1]});
            }

            if(go < MAX && (visited[go] == 0 || visited[go] > tmp[1] + 1)) {
                visited[go] = tmp[1] + 1;
                q.add(new int[] {go, tmp[1] + 1});
            }

            if(back >= 0 && (visited[back] == 0 || visited[back] > tmp[1] + 1)) {
                visited[back] = tmp[1] + 1;
                q.add(new int[] {back, tmp[1] + 1});
            }
        }

        System.out.println(visited[M] - 1);
    }
}