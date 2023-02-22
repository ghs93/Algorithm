package baekjoon.P11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11404. 플로이드 - 골드 4
 * @author hoseong
 * @category 플로이드-워셜
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            if(map[from][to] == 0 || map[from][to] > pay)
                map[from][to] = pay;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if(k == i) continue;

                for (int j = 1; j <= N; j++) {
                    if(i == j) continue;

                    if(map[i][k] == 0 || map[k][j] == 0) continue;

                    if(map[i][j] == 0 || map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                sb.append(map[i][j]).append(' ');

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
