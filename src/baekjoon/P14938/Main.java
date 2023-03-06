package baekjoon.P14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 14938. 서강그라운드 - 골드 4
 * @author hoseong
 * @category 데이크스트라
 */
public class Main {
    static int N, M, R;
    static int[] items;
    static ArrayList<int[]>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        items = new int[N+1];
        map = new ArrayList[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            map[a].add(new int[] {b, l});
            map[b].add(new int[] {a, l});
        }

        int result = 0;
        for (int i = 1; i < N+1; i++) {
            result = Math.max(result, findItem(i));
        }

        System.out.println(result);
    }

    static int findItem(int start) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] D = new int[N+1];
        Arrays.fill(D, M+1);

        q.add(new int[] {start, 0});
        D[start] = 0;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();

            if (D[tmp[0]] < tmp[1]) continue;

            for (int[] m : map[tmp[0]]) {
                int cost = D[tmp[0]] + m[1];

                if (cost < D[m[0]]) {
                    D[m[0]] = cost;
                    q.add(new int[] {m[0], cost});
                }
            }
        }

        int max = 0;
        for (int i = 1; i < N+1; i++) {
            if (D[i] <= M) max += items[i];
        }

        return max;
    }
}
