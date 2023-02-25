package baekjoon.P15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 15652. N과 M (4) - 실버 3
 * @author hoseong
 * @category 중복수열
 */
public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        perm(1, 0);
        System.out.println(sb);
    }

    static void perm(int start, int cnt) {
        if(cnt == M) {
            for(int a : arr)
                sb.append(a).append(' ');
            sb.append('\n');

            return;
        }

        for (int i = start; i <= N; i++) {
            if(cnt > 0 && arr[cnt-1] > i) continue;
            arr[cnt] = i;
            perm(start, cnt + 1);
        }
    }
}
