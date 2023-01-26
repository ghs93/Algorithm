package baekjoon.P1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1005. ACM Craft - 골드 3
 * @author hoseong
 * @category 위상정렬
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] d = new int[N+1];

            for (int i = 1; i <= N; i++) {
                d[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer>[] map = new ArrayList[N+1];
            for (int i = 1; i <= N; i++) {
                map[i] = new ArrayList<>();
            }

            int[] inDegree = new int[N+1];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                map[from].add(to);
                inDegree[to]++;
            }

            int W = Integer.parseInt(br.readLine());

            if(inDegree[W] == 0) {
                sb.append(d[W]).append('\n');

            } else {
                int[] total = new int[N+1];
                Queue<Integer> q = new ArrayDeque<>();

                for (int i = 1; i <= N; i++) {
                    total[i] = d[i];

                    if(inDegree[i] == 0)
                        q.add(i);
                }

                while (!q.isEmpty()) {
                    for (int i = 0, size = q.size(); i < size; i++) {
                        int start = q.poll();

                        for(int j : map[start]) {
                            total[j] = Math.max(total[j], total[start] + d[j]);

                            if(--inDegree[j] == 0)
                                q.add(j);
                        }
                    }
                }

                sb.append(total[W]).append('\n');
            }
        }

        System.out.println(sb);
    }
}
