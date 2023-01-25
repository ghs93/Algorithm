package baekjoon.P14003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 백준 14003. 가장 긴 증가하는 부분 수열 5 - 플레티넘 5
 * @author hoseong
 * @category LIS
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N];
        ArrayList<Integer> indexs = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < N; i++) {
            int search = Arrays.binarySearch(lis, 0, size, arr[i]);

            if(search >= 0) {
                indexs.add(size);
                continue;
            }

            int position = Math.abs(search) - 1;
            indexs.add(position);
            lis[position] = arr[i];

            if(position == size) size++;
        }

        System.out.println(size);

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = indexs.size()-1; i >= 0; i--) {
            if(indexs.get(i) == size - 1) {
                stack.push(arr[i]);
                size--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }

        System.out.println(sb);
    }
}