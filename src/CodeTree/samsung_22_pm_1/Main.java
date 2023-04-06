package CodeTree.samsung_22_pm_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Man {
        int r, c;
        
        Man(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int n, m;
    static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    static boolean[][][] visited;
    static int[][] map;
    static Man[] store;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        visited = new boolean[m+1][n+1][n+1];
        store = new Man[m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            store[i] = new Man(r, c);
        }

        System.out.println(move());
    }

    static int move() {
        int time = 1;
        int cnt = 0;

        Queue<Man>[] q = new ArrayDeque[m+1];
        for (int i = 0; i <= m; i++) {
            q[i] = new ArrayDeque<>();
        }

        Man tmp = findCamp(store[time]);
        q[1].add(tmp);
        visited[0][tmp.r][tmp.c] = true;
        visited[1][tmp.r][tmp.c] = true;

        while (cnt < m) {
            time++;

            //move
            for (int i = 1; i <= Math.min(time, m); i++) {
//                System.out.println("i: " + i + ", size: " + q[i].size());
                bfs: for (int j = 0, size = q[i].size(); j < size; j++) {
                    Man m = q[i].poll();

//                    if (m.r == store[i].r && m.c == store[i].c) {
//                        System.out.println("time: " + time + ", r: " + m.r + ", c: " + m.c);
//                        cnt++;
//                        q[i].clear();
//                        visited[0][m.r][m.c] = true;
//                        break;
//                    }

                    for (int d = 0; d < 4; d++) {
                        int dr = m.r + dir[d][0];
                        int dc = m.c + dir[d][1];

                        if (dr <= 0 || dr > n || dc <= 0 || dc > n || visited[i][dr][dc] || visited[0][dr][dc]) continue;

                        visited[i][dr][dc] = true;
                        q[i].add(new Man(dr, dc));

                        if (dr == store[i].r && dc == store[i].c) {
//                            System.out.println("time: " + time + ", r: " + dr + ", c: " + dc);
                            cnt++;
                            q[i].clear();
                            visited[0][dr][dc] = true;
                            break bfs;
                        }
                    }
                }
            }

            if (time <= m) {
                Man tt = findCamp(store[time]);
                visited[0][tt.r][tt.c] = true;
//                System.out.println("time: " + time + ", r: " + tt.r + ", c: " + tt.c);
                q[time].add(tt);
            }
        }

        return time;
    }

    static Man findCamp(Man man) {
        Queue<Man> q = new ArrayDeque<>();
        PriorityQueue<Man> pq = new PriorityQueue<>(new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                if (o1.r == o2.r) return o1.c - o2.c;
                return o1.r - o2.r;
            }
        });
        boolean[][] v = new boolean[n+1][n+1];

        q.add(man);
        v[man.r][man.c] = true;

        while (!q.isEmpty()) {
            Man m = q.poll();

            for (int d = 0; d < 4; d++) {
                int dr = m.r + dir[d][0];
                int dc = m.c + dir[d][1];

                if (dr <= 0 || dr > n || dc <= 0 || dc > n || v[dr][dc] || visited[0][dr][dc]) continue;

                v[dr][dc] = true;
                q.add(new Man(dr, dc));

                if (map[dr][dc] == 1) pq.add(new Man(dr, dc));
            }

            if (!pq.isEmpty()) break;
        }

        return pq.poll();
    }
}