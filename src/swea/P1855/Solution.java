package swea.P1855;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * SWEA 1855. 영준이의 진짜 BFS
 * @author hoseong
 * @category BFS
 */
public class Solution {
    static class Node {
        int from;
        int cur;
        int depth;

        Node(int from, int cur, int depth) {
            this.from = from;
            this.cur = cur;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] arr = new ArrayList[N+1];
            for (int i = 0; i <= N; i++) {
                arr[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 2; i <= N; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                arr[tmp].add(i);
                arr[i].add(tmp);
            }

            Queue<Node> target = new ArrayDeque<>();
            Queue<Node> q = new ArrayDeque<>();
            boolean[] qv = new boolean[N+1];
            q.add(new Node(0, 1, 0));
            qv[1] = true;

            while (!q.isEmpty()) {
                Node temp = q.poll();
                target.add(temp);

                for (int tmp : arr[temp.cur]) {
                    if (qv[tmp]) continue;

                    qv[tmp] = true;
                    q.add(new Node(temp.cur, tmp, temp.depth + 1));
                }
            }

            int result = 0;
            while (target.size() > 1) {
                Node node = target.poll();

                if (node.depth != target.peek().depth) {
                    if (target.peek().from == node.cur)
                        result += 1;
                    else
                        result += (node.depth * 2);

                } else {
                    if (node.from != target.peek().from) {
                        result += 4;

                    } else {
                        result += 2;
                    }
                }
            }

            sb.append('#').append(test_case).append(' ').append(result).append('\n');
        }

        System.out.println(sb);
    }
}
