package baekjoon.P18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 18111. 마인크래프트 - 실버 2
 * @author hoseong
 * @category 구현
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int top = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                top = Math.max(top, map[i][j]);
            }
        }

        int totalTime = Integer.MAX_VALUE, max = 0;
        for (int t = 0; t <= top; t++) {
            int item = B;
            int time = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int block = map[i][j];

                    if(block == t)
                        continue;

                    if(block > t) {
                        time += (block - t) * 2;
                        item += (block - t);

                    } else {
                        time += (t - block);
                        item -= (t - block);
                    }
                }
            }

            if(item < 0)
                continue;

            if(totalTime > time) {
                totalTime = time;
                max = t;

            } else if(totalTime == time && t > max) {
                max = t;
            }
        }

        System.out.println(totalTime + " " + max);
    }
}