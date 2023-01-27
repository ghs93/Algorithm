package baekjoon.P10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 10942. 팰린드롬? - 골드 4
 * @author hoseong
 * @category 이분 탐색, DP
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        /* 이분 탐색 */
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            int from = Integer.parseInt(st.nextToken());
//            int to = Integer.parseInt(st.nextToken());
//
//            boolean pal = true;
//            while (from < to) {
//                if(arr[from] != arr[to]) {
//                    pal = false;
//                    break;
//                }
//
//                from++;
//                to--;
//            }
//
//            sb.append(pal ? '1' : '0').append('\n');
//        }

        /* DP */
        boolean[][] dp = new boolean[N+1][N+1];
        //1~2칸
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;

            if(i < N && arr[i] == arr[i+1]) {
                dp[i][i+1] = true;
            }
        }

        //3칸 이상
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1])
                    dp[j][j+i] = true;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            sb.append(dp[from][to] ? '1' : '0').append('\n');
        }

        System.out.println(sb);
    }
}
