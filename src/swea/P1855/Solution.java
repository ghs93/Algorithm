package swea.P1855;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * SWEA 1855. 영준이의 진짜 BFS
 * @author hoseong
 * @category BFS, LCA(공통 조상 찾기)
 */
public class Solution {
    static int[] depth;
    static int[][] parent;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            depth = new int[N+1];
            parent = new int[N+1][20];
            arr = new ArrayList[N+1];
            for (int i = 0; i <= N; i++) {
                arr[i] = new ArrayList<>();
            }

            // tree 만들기
            st = new StringTokenizer(br.readLine());
            for (int i = 2; i <= N; i++) {
                int p = Integer.parseInt(st.nextToken());

                arr[p].add(i); // 자식 노드 추가
                depth[i] = depth[p] + 1; // 자식 노드의 depth => 부모 노드의 depth + 1
                parent[i][0] = p; // 자식 노드의 바로 위(2^0 위치) 부모
            }

            // depth 별로 조상 노드 표시
            for (int y = 1; y < 20; y++) {
                for (int x = 1; x <= N; x++) {
                    parent[x][y] = parent[parent[x][y-1]][y-1];
                }
            }

            sb.append('#').append(test_case).append(' ').append(bfs(N)).append('\n');
        }

        System.out.println(sb);
    }

    static long bfs(int n) {
        long result = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        int pre = 1; // 출발 노드

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int y : arr[x]) {
                q.add(y);

                result += LCA(pre, y);
                pre = y;
            }
        }

        return result;
    }

    static int LCA(int x, int y) {
        int cnt = 0;

        // 분기별 처리를 하지 않기 위한 depth 조절
        if (depth[x] > depth[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        // 도착지가 바로 부모일 경우
        if (parent[y][0] == x) {
            return 1;
        }

        // x와 y의 depth 맞추기
        for (int i = 19; i >= 0; i--) {
            if (depth[y] - depth[x] >= (1<<i)) {
                y = parent[y][i];
                cnt += (1<<i);
            }
        }

        // x와 y의 공통 조상 또는 공통 조상 바로 아래 찾기
        if (parent[y][0] != parent[x][0]) {
            for (int i = 19; i >= 0; i--) {
                if (parent[x][i] != parent[y][i]) {
                    x = parent[x][i];
                    y = parent[y][i];
                    cnt += (1<<i) * 2;
                }
            }
        }

        // x와 y의 바로 위 부모가 같을 경우
        if (parent[x][0] == parent[y][0])
            cnt += 2;

        return cnt;
    }
}
