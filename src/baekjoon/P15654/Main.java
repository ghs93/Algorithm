package baekjoon.P15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 15654. N과 M (5) - 실버 3
 * @author hoseong
 * @category 순열
 */
public class Main {
    static int N, M;
    static int[] arr, tmp;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        tmp = new int[M];
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        perm(0);

        System.out.println(sb);
    }

    static void perm(int cnt) {
        if (cnt == M) {
            for(int t : tmp)
                sb.append(t).append(' ');

            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if(isSelected[i]) continue;

            isSelected[i] = true;
            tmp[cnt] = arr[i];
            perm(cnt+1);

            isSelected[i] = false;
        }
    }
}
