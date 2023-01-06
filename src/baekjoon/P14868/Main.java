package baekjoon.P14868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 14868. 문명 - 플래티넘 4
 * @author hoseong
 * @category
 */
public class Main {
    static int N, K;
    static int[][] map;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];
        parents = new int[K+1];

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N+1][N+1];
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = i;
            parents[i] = i;

            visited[x][y] = true;
            for (int d = 0; d < 4; d++) {
                int dr = x + dir[d][0];
                int dc = y + dir[d][1];

                if(dr <= 0 || dr > N || dc <= 0 || dc > N) continue;

                if(!visited[dr][dc]) {
                    map[dr][dc] = map[x][y];
                    q.add(new int[] {dr, dc});
                    visited[dr][dc] = true;
                }
            }
        }

//        System.out.println("parents: " + Arrays.toString(parents));
//        for (int[] m :
//                map) {
//            System.out.println(Arrays.toString(m));
//        }
//        System.out.println();

        int cnt = 0;
        while(!q.isEmpty() && !check()) {
            for (int s = 0, size = q.size(); s < size; s++) {
                int[] mun = q.poll();
                int r = mun[0];
                int c = mun[1];

                for (int i = 0; i < 4; i++) {
                    int dr = r + dir[i][0];
                    int dc = c + dir[i][1];

                    if(dr <= 0 || dr > N || dc <= 0 || dc > N) continue;

                    if(map[dr][dc] != 0 && (find(map[r][c]) != find(map[dr][dc]))) {
                        union(map[r][c], map[dr][dc]);

                    } else if(!visited[dr][dc]) {
                        visited[dr][dc] = true;
                        map[dr][dc] = map[r][c];

                        q.add(new int[] {dr, dc});
                    }
                }
            }

            cnt++;
//            System.out.println("year: " + cnt);
//            System.out.println("parents: " + Arrays.toString(parents));
//            for (int[] m :
//                    map) {
//                System.out.println(Arrays.toString(m));
//            }
//            System.out.println();
        }

        System.out.println(cnt);
    }

    private static int find(int a) {
        if(a == parents[a])
            return a;

        return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b) {
        int pa = parents[a];
        int pb = parents[b];

        if(pa != pb) {
            if(pa > pb)
                parents[b] = pa;
            else
                parents[a] = pb;
        }
    }

    private static boolean check() {
        int tmp = find(parents[1]);

        for (int i = 2; i <= K; i++) {
            if(tmp != find(parents[i])) return false;
        }

        return true;
    }
}
