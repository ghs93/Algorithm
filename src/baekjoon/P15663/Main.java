package baekjoon.P15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 백준 15663. N과 M (9) - 실버 2
 * @author hoseong
 * @category 순열
 */
public class Main {
    static int N, M;
    static int[] arr, tmp;
    static boolean[] isSelected;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isSelected = new boolean[N];
        arr = new int[N];
        tmp = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        perm(0);

        System.out.println(sb);
    }

    static void perm(int cnt) {
        if(cnt == M) {
            StringBuilder builder = new StringBuilder();
            for(int t : tmp)
                builder.append(t).append(' ');

            if(set.contains(builder.toString())) return;

            set.add(builder.toString());
            sb.append(builder).append('\n');

            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i]) continue;

            isSelected[i] = true;
            tmp[cnt] = arr[i];
            perm(cnt+1);
            isSelected[i] = false;
        }
    }
}
