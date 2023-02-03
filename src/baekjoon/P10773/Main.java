package baekjoon.P10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 10773. 제로 - 실버 4
 * @author hoseong
 * @category 스택
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        long result = 0;
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) {
                result -= stack.pop();

            } else {
                result += num;
                stack.push(num);
            }
        }

        System.out.println(result);
    }
}
