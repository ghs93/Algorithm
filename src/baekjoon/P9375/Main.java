package baekjoon.P9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 백준 9375. 패션왕 신해빈 - 실버 3
 * @author hoseong
 * @category HashMap, 조합
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                st.nextToken();
                String key = st.nextToken();
                map.put(key, map.getOrDefault(key, 1) + 1);
            }

            int total = 1;
            for(int m : map.values()) {
                total *= m;
            }

            sb.append(total - 1).append('\n');
        }

        System.out.println(sb);
    }
}
