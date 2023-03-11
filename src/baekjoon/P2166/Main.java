package baekjoon.P2166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2166. 다각형의 면적 - 골드 5
 * @author hoseong
 * @category 기하학
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 신발끈 공식 사용 - https://ko.wikipedia.org/wiki/%EC%8B%A0%EB%B0%9C%EB%81%88_%EA%B3%B5%EC%8B%9D
        int N = Integer.parseInt(br.readLine());
        long[][] map = new long[N+1][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        map[N][0] = map[0][0];
        map[N][1] = map[0][1];

        long x2y = 0;
        long y2x = 0;
        for (int i = 0; i < N; i++) {
            x2y += map[i][0] * map[i+1][1];
            y2x += map[i+1][0] * map[i][1];
        }

        double result = Math.abs(x2y - y2x) / 2.0;
        System.out.printf("%.1f", result);
    }
}
