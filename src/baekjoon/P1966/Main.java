package baekjoon.P1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1966. 프린터 큐 - 실버 3
 * @author hoseong
 * @category 큐
 */
public class Main {
    static class Print {
        int idx;
        boolean target;

        public Print(int idx, boolean target) {
            this.idx = idx;
            this.target = target;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            LinkedList<Print> q = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                int idx = Integer.parseInt(st.nextToken());
                q.add(new Print(idx, i == M));
            }

            if(N == 1) {
                sb.append('1').append('\n');

            } else {
                int result = 0;
                while (!q.isEmpty()) {
                    Print front = q.poll();

                    boolean isMax = true;
                    for(int i = 0, size = q.size(); i < size; i++) {
                        if(front.idx < q.get(i).idx) {
                            isMax = false;

                            q.add(front);
                            for (int j = 0; j < i; j++) {
                                q.add(q.poll());
                            }
                            break;
                        }
                    }

                    if(!isMax) continue;

                    result++;
                    if(front.target) {
                        break;
                    }
                }

                sb.append(result).append('\n');
            }
        }

        System.out.println(sb);
    }
}
