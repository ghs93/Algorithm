package swea.P2930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * SWEA 2930. 힙
 * @author hoseong
 * @category 구현
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int exec = Integer.parseInt(st.nextToken());
                if (exec == 1) {
                    int add = Integer.parseInt(st.nextToken());
                    pq.add(add);

                } else {
                    if (pq.isEmpty()) {
                        sb.append(-1).append(' ');

                    } else {
                        int add = pq.poll();
                        sb.append(add).append(' ');
                    }
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
