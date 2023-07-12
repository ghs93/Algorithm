package swea.P17670;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static class Cell {
        int r, c, x;

        public Cell(int r, int c, int x) {
            this.r = r;
            this.c = c;
            this.x = x;
        }

        @Override
        public String toString() {
            return "r : " + r + ", c : " + c + ", x : " + x;
        }
    }

    static int N, M, Q;
    static int[][] map;
    static int[] rows, cols;
    static int cnt, total;
    static Cell[] safeRows, safeCols;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            total = 0;

            map = new int[N + 1][M + 1];

            rows = new int[N + 1];
            safeRows = new Cell[N + 1];

            cols = new int[M + 1];
            safeCols = new Cell[M + 1];

            // 곰팡이 입력 및 세이프존 설정
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= M; j++) {
                    int x = Integer.parseInt(st.nextToken());
                    map[i][j] = x;

                    if (x > rows[i]) {
                        rows[i] = x;
                        safeRows[i] = new Cell(i, j, x);
                    }

                    if (x > cols[j]) {
                        cols[j] = x;
                        safeCols[j] = new Cell(i, j, x);
                    }
                }
            }

            for (int i = 1; i <= N; i++) {
                if (safeRows[i].x == safeCols[safeRows[i].c].x) cnt++;
            }

            boolean isChange = false;
            for (int i = 0; i < Q; i++) {
                isChange = false;

                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                if (rows[r] < x) {
                    isChange = true;

                    rows[r] = x;
                    safeRows[r].c = c;
                    safeRows[r].x = x;
                }

                if (cols[c] < x) {
                    isChange = true;

                    cols[c] = x;
                    safeCols[c].r = r;
                    safeCols[c].x = x;
                }

                if (isChange) {
                    cnt = 0;

                    if (N < M) {
                        for (int j = 1; j <= N; j++) {
                            if (safeRows[j].x == safeCols[safeRows[j].c].x) cnt++;
                        }

                    } else {
                        for (int j = 1; j <= M; j++) {
                            if (safeRows[safeCols[j].r].x == safeCols[j].x) cnt++;
                        }
                    }
                }

                total += cnt;
            }

            System.out.println("#" + test_case + " " + total);
        }
    }
}