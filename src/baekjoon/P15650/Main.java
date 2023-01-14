package baekjoon.P15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 15650. N과 M(2) - 실버 3
 * @author hoseong
 * @category
 */
public class Main {
    static ArrayList<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();

        make(n, m, 1);
    }

    private static void make(int n, int m, int start) {
        if(arr.size() == m) {
            for (int a : arr)
                System.out.print(a + " ");
            System.out.println();
            return;
        }

        for (int i = start; i<=n; i++) {
            arr.add(i);
            make(n, m, i+1);
            arr.remove(Integer.valueOf(i));
        }
    }
}
