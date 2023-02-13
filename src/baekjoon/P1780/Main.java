package baekjoon.P1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1780. 종이의 개수 - 실버 2
 * @author hoseong
 * @category
 */
public class Main {
    static int zero = 0, minus = 0, one = 0;
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

        makePaper(N, 0, 0);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    static void makePaper(int size, int r, int c) {
        if (size == 1) {
            if (map[r][c] == -1) minus++;
            else if (map[r][c] == 0) zero++;
            else one++;

            return;
        }

        boolean isSame = true;
        loop: for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[r][c] != map[i][j]) {
                    isSame = false;
                    break loop;
                }
            }
        }

        if (isSame) {
            if (map[r][c] == -1) minus++;
            else if (map[r][c] == 0) zero++;
            else one++;

        } else {
            int tSize = size / 3;

            makePaper(tSize, r, c);
            makePaper(tSize, r, c + tSize);
            makePaper(tSize, r, c + (tSize * 2));
            makePaper(tSize, r + tSize, c);
            makePaper(tSize, r + tSize, c + tSize);
            makePaper(tSize, r + tSize, c + (tSize * 2));
            makePaper(tSize, r + (tSize * 2), c);
            makePaper(tSize, r + (tSize * 2), c + tSize);
            makePaper(tSize, r + (tSize * 2), c + (tSize * 2));
        }
    }
}
