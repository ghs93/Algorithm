package baekjoon.P12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 12851. 숨바꼭질 2 - 골드 4
 * @author hoseong
 * @category BFS
 */
public class Main {
    static int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new ArrayDeque<>();
        int[] visited = new int[MAX];
        Arrays.fill(visited, MAX);

        q.add(new int[] {N, 0});
        visited[N] = 0;

        int min = MAX;
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] m = q.poll();

            if (m[0] == K) {
                if (m[1] > min) continue;

                if (m[1] == min) cnt++;
                else {
                    min = m[1];
                    cnt = 1;
                }

                continue;
            }

            if (m[0] < K) {
                int add = m[0] + 1;
                int mul = m[0] * 2;

                if (add < MAX && m[1] <= visited[add]) {
                    visited[add] = m[1];
                    q.add(new int[] {add, m[1]+1});
                }

                if (mul < MAX && m[1] <= visited[mul]) {
                    visited[mul] = m[1];
                    q.add(new int[] {mul, m[1]+1});
                }
            }

            if (m[0] > 0) {
                int back = m[0] - 1;

                if (m[1] <= visited[back]) {
                    visited[back] = m[1];
                    q.add(new int[] {back, m[1]+1});
                }
            }
        }

        System.out.println(min);
        System.out.println(cnt);
    }
}