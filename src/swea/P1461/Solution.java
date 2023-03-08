package swea.P1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * SWEA 1461. 프로세서 연결하기
 * @author hoseong
 * @category DFS
 */
public class Solution {
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N;
    static int[][] map;
    static ArrayList<int[]> position;
    static int min, core;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append('#').append(test_case).append(' ');

            min = Integer.MAX_VALUE;
            core = 0;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            position = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    int pc = Integer.parseInt(st.nextToken());
                    map[i][j] = pc;

                    if (pc == 1 && (i > 0 && i < N-1) && (j > 0 && j < N-1)) {
                        position.add(new int[] {i, j});
                    }
                }
            }

            dfs(0, 0, 0);
            sb.append(min).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int n, int step, int c) {
        if (n == position.size()) {
            if (c > core) {
                core = c;
                min = step;

            } else if (c == core) {
                min = Math.min(min, step);
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            int dr = position.get(n)[0];
            int dc = position.get(n)[1];

            int cnt = 0;
            boolean isCross = false;
            while (true) {
                dr += dir[i][0];
                dc += dir[i][1];

                if (dr < 0 || dr >= N || dc < 0 || dc >= N) break;

                if (map[dr][dc] == 1) {
                    isCross = true;
                    break;
                }

                cnt++;
                map[dr][dc] = 1;
            }

            if (!isCross) dfs(n+1, step + cnt, c+1);
            else dfs(n+1, step, c);

            while (true) {
                dr -= dir[i][0];
                dc -= dir[i][1];

                if (dr == position.get(n)[0] && dc == position.get(n)[1]) break;

                map[dr][dc] = 0;
            }
        }
    }
}
