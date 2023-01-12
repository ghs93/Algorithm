package baekjoon.P1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 1991. 트리 순회 - 실버 1
 * @author hoseong
 * @category
 */
public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        arr = new int[26][2];

        // . -> 46
        // A -> 65
        // Z -> 90
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            arr[(int)root][0] = (int)left;
            arr[(int)root][1] = (int)right;
        }
    }
}
