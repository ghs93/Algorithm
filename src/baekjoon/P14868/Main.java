package baekjoon.P14868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 14868. 문명 - 플래티넘 4
 * @author hoseong
 * @category BFS, 분리 집합
 */
public class Main {
    static int N, K, group;
    static int[][] map;
    static int[] parents;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        group = K;

        map = new int[N+1][N+1];
        parents = new int[K+1];

        q = new ArrayDeque<>();

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = i;
            parents[i] = i;

            q.add(new int[] {x, y});
        }

        join();

        int cnt = 0;
        while(group != 1) {
            cnt++;

            for (int s = 0, size = q.size(); s < size; s++) {
                int[] mun = q.poll();
                int r = mun[0];
                int c = mun[1];

                for (int i = 0; i < 4; i++) {
                    int dr = r + dir[i][0];
                    int dc = c + dir[i][1];

                    if(dr <= 0 || dr > N || dc <= 0 || dc > N) continue;

                    if(map[dr][dc] == 0) {
                        map[dr][dc] = map[r][c];
                        q.add(new int[] {dr, dc});
                    }
                }
            }

            join();
        }

        System.out.println(cnt);
    }

    private static void join() {
        for (int i = 0, size = q.size(); i < size; i++) {
            int[] m = q.poll();
            int r = m[0];
            int c = m[1];

            for (int d = 0; d < 4; d++) {
                int dr = r + dir[d][0];
                int dc = c + dir[d][1];

                if(dr <= 0 || dr > N || dc <= 0 || dc > N) continue;

                if(map[dr][dc] != 0 && find(map[r][c]) != find(map[dr][dc])) {
                    union(map[r][c], map[dr][dc]);
                    group--;
                }
            }

            q.add(m);
        }
    }

    private static int find(int a) {
        if(a == parents[a])
            return a;

        return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return;

        parents[pa] = pb;
    }
}