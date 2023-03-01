package baekjoon.P1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 1043. 거짓말 - 골드 4
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

        st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());

        if (people == 0) {
            System.out.println(M);
            return;
        }

        parents = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        int base = Integer.parseInt(st.nextToken());
        for (int i = 1; i < people; i++) {
            union(base, Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer>[] party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            party[i].add(Integer.parseInt(st.nextToken()));
            for (int j = 1; j < cnt; j++) {
                int num = Integer.parseInt(st.nextToken());
                party[i].add(num);

                union(party[i].get(0), num);
            }
        }

        int result = M;
        for (ArrayList<Integer> pt : party) {
            for (int p : pt) {
                if (find(p) == find(base)) {
                    result--;
                    break;
                }
            }
        }

        System.out.println(result);
    }

    static int find(int a) {
        if (a == parents[a]) return a;

        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return;

        parents[pb] = parents[pa];
    }
}
