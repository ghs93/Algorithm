package baekjoon.P1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 1389. 케빈 베이컨의 6단계 법칙 - 실버 1
 * @author hoseong
 * @category 플로이드-워셜
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];
        for(int[] m : map)
            Arrays.fill(m, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from][to] = 1;
            map[to][from] = 1;
        }

        for (int k = 1; k < N+1; k++) {
            for (int i = 1; i < N+1; i++) {
                if(k == i) continue;

                for (int j = 1; j < N+1; j++) {
                    if(i == j) continue;

                    int path = map[i][k] + map[k][j];
                    map[i][j] = Math.min(map[i][j], path);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int posi = 1;
        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 1; j <= N; j++) {
                if(i == j) continue;

                tmp += map[i][j];
            }

            if ( tmp < min) {
                min = tmp;
                posi = i;
            }
        }

        System.out.println(posi);
    }
}
