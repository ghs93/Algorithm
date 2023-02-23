package baekjoon.P2263;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2263. 트리의 순회 - 골드 2
 * @author hoseong
 * @category 재귀
 */
public class Main {
    static int index = 0;
    static int[] in, post, pre;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        in = new int[N];
        post = new int[N];
        pre = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, N-1, 0, N-1);
        System.out.println(sb);
    }

    static void dfs(int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart <= inEnd) {
            int root = post[postEnd];
            sb.append(root).append(' ');

            int r = inStart;
            for (int i = inStart; i <= inEnd; i++) {
                if (in[i] == root) {
                    r = i;
                    break;
                }
            }

            //left
            dfs(inStart, r-1, postStart, postStart + r - inStart - 1);

            //right
            dfs(r+1, inEnd, postStart + r - inStart, postEnd - 1);
        }
    }
}
