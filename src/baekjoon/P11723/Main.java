package baekjoon.P11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 백준 11723. 집합 - 실버 5
 * @author hoseong
 * @category 구현
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        Set<Integer> S = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String sh = st.nextToken();
            int idx;

            switch (sh) {
                case "add":
                    idx = Integer.parseInt(st.nextToken());
                    S.add(idx);
                    break;

                case "remove":
                    idx = Integer.parseInt(st.nextToken());
                    S.remove(idx);
                    break;

                case "check":
                    idx = Integer.parseInt(st.nextToken());
                    sb.append(S.contains(idx) ? 1 : 0).append('\n');
                    break;

                case "toggle":
                    idx = Integer.parseInt(st.nextToken());
                    if(S.contains(idx))
                        S.remove(idx);
                    else
                        S.add(idx);
                    break;

                case "all":
                    for (int j = 1; j < 21; j++) {
                        S.add(j);
                    }
                    break;

                case "empty":
                    S.clear();
                    break;
            }
        }

        System.out.println(sb);
    }
}
