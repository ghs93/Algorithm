package baekjoon.P20040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 20040. 사이클 게임 - 골드 4
 * @author hoseong
 * @category 분리 집합
 */
public class Main {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        int result = 0;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(union(a, b)) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    public static int find(int a) {
        int pa = parents[a];

        if(pa == a)
            return a;

        return parents[a] = find(pa);
    }

    public static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return true;

        if (pa < pb) {
            parents[pb] = pa;

        } else {
            parents[pa] = pb;
        }

        return false;
    }
}
