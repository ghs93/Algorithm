package baekjoon.P1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 1918. 후위 표기식 - 골드 2
 * @author hoseong
 * @category 스택
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0, size = str.length(); i < size; i++) {
            char c = str.charAt(i);

            if(c >= 'A' && c <= 'Z') {
                sb.append(c);
                continue;
            }

            if(stack.isEmpty() || c == '(') {
                stack.push(c);
                continue;
            }

            if(c == ')') {
                while (!stack.isEmpty()) {
                    char tmp = stack.pop();

                    if(tmp == '(') break;

                    sb.append(tmp);
                }
                continue;
            }

            if(check(stack.peek()) < check(c)) {
                stack.push(c);

            } else {
                while (!stack.isEmpty() && check(stack.peek()) >= check(c)) {
                    sb.append(stack.pop());
                }

                stack.push(c);
            }
        }

        while (!stack.isEmpty())
            sb.append(stack.pop());

        System.out.println(sb);
    }

    static int check(char ch) {
        if(ch == '+' || ch == '-') return 1;
        if(ch == '*' || ch == '/') return 2;
        return 0;
    }
}
