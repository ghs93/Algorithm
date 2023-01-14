package baekjoon.P1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1991. 트리 순회 - 실버 1
 * @author hoseong
 * @category 재귀
 */
public class Main {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

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

            arr[(int)root - 65][0] = (int)left;
            arr[(int)root - 65][1] = (int)right;
        }

        preorder(65);
        sb.append('\n');
        inorder(65);
        sb.append('\n');
        postorder(65);

        System.out.println(sb);
    }

    //전위 순회 - 루트, 왼쪽, 오른쪽
    private static void preorder(int index) {
        if(index == 0 || index == 46)
            return;

        sb.append((char)index);
        preorder(arr[index-65][0]);
        preorder(arr[index-65][1]);
    }

    //중위 순회 - 왼쪽, 루트, 오른쪽
    private static void inorder(int index) {
        if(index == 0 || index == 46)
            return;

        inorder(arr[index-65][0]);
        sb.append((char)index);
        inorder(arr[index-65][1]);
    }

    //후위 순회 - 왼쪽, 오른쪽, 루트
    private static void postorder(int index) {
        if(index == 0 || index == 46)
            return;

        postorder(arr[index-65][0]);
        postorder(arr[index-65][1]);
        sb.append((char)index);
    }
}
