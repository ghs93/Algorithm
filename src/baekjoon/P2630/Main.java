package baekjoon.P2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2630. 색종이 만들기 - 실버 2
 * @author hoseong
 * @category DFS
 */
public class Main {
    static int white = 0;
    static int blue = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(N, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }

    static void dfs(int size, int r, int c) {
        if(size == 1) {
            if(map[r][c] == 0) white++;
            else blue++;

            return;
        }

        int color = map[r][c];
        boolean isSame = true;
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(color != map[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }

        if(isSame) {
            if(color == 0) white++;
            else blue++;

        } else {
            int half = size / 2;

            dfs(half, r, c);
            dfs(half, r, c + half);
            dfs(half, r + half, c);
            dfs(half, r + half, c + half);
        }
    }
}
