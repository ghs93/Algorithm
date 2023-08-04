package baekjoon.P16562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 16562. 친구비 - 골드 4
 * @author hoseong
 * @category 분리 집합
 */
public class Main {
    final static int MAX_MONEY = 10000001;
    static int n, m, k;
    static int[] parents;
    static int[] pay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        pay = new int[n+1];
        parents = new int[n+1];

        st = new StringTokenizer(br.readLine());
        pay[0] = MAX_MONEY;
        for (int i = 1; i <= n; i++) {
            pay[i] = Integer.parseInt(st.nextToken());
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int cost = 0;
        for (int i = 1; i <= n; i++) {
            int friend = find(i);

            if (friend != find(0)) {
                cost += pay[friend];
                union(0, friend);
            }
        }

        if (cost > k) System.out.println("Oh no");
        else System.out.println(cost);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            if (pay[pa] > pay[pb]) parents[pa] = pb;
            else parents[pb] = pa;
        }
    }

    static int find(int a) {
        if (parents[a] == a) return a;

        return find(parents[a]);
    }
}
