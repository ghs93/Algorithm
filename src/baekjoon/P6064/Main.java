package baekjoon.P6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 6064. 카잉 달력 - 실버 1
 * @author hoseong
 * @category 수학
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        tc: for (int t = 0; t < T; t++) {
             st = new StringTokenizer(br.readLine());

             int M = Integer.parseInt(st.nextToken());
             int N = Integer.parseInt(st.nextToken());
             int X = Integer.parseInt(st.nextToken()) - 1;
             int Y = Integer.parseInt(st.nextToken()) - 1;

            for (int i = X; i < N * M; i+=M) {
                if(i % N == Y) {
                    sb.append(i + 1).append('\n');
                    continue tc;
                }
            }

            sb.append(-1).append('\n');
        }

        System.out.println(sb);
    }
}
