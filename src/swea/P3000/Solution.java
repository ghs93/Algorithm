package swea.P3000;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * SWEA 3000. 중간값 구하기
 * @author hoseong
 * @category
 */
public class Solution {
    final static int MOD = 20171109;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append('#').append(test_case).append(' ');
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            long result = 0;
            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (x > A)
                    right.add(x);
                else
                    left.add(x);

                if (y > A)
                    right.add(y);
                else
                    left.add(y);


                if (left.size() > right.size()) {
                    while (left.size() != right.size()) {
                        right.add(A);
                        A = left.poll();
                    }

                } else if (left.size() < right.size()) {
                    while (left.size() != right.size()) {
                        left.add(A);
                        A = right.poll();
                    }
                }

                result += A;
                result %= MOD;
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}
