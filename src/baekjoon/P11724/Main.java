package baekjoon.P11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 백준 11724. 연결 요소의 개수 - 실버 2
 * @author hoseong
 * @category 서로소 집합(Union-Find)
 */
public class Main {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(find(parents[i]));
        }

        System.out.println(set.size());
    }

    static int find(int a) {
        int pa = parents[a];

        if(pa == a)
            return a;
        else
            return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) {
            return true;

        } else {
            parents[pb] = pa;
            return false;
        }
    }
}
