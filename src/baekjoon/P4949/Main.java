package baekjoon.P4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 4949. 균형잡힌 세상 - 실버 4
 * @author hoseong
 * @category 스택
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // ( => 40
        // ) => 41
        // [ => 91
        // ] => 93
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        String str;
        while (!(str = br.readLine()).equals(".")) {
            boolean isCorrect = true;
            for (int i = 0, size = str.length(); i < size; i++) {
                int ch = str.charAt(i);

                if(ch == 40 || ch == 91) {
                    stack.push(ch);

                } else if(ch == 41 || ch == 93) {
                    if(stack.isEmpty()) {
                        isCorrect = false;
                        break;
                    }

                    int correct = stack.pop();
                    if((correct == 40 && ch != 41) || (correct == 91 && ch != 93)) {
                        isCorrect = false;
                        break;
                    }
                }
            }

            sb.append((isCorrect && stack.isEmpty()) ? "yes" : "no").append('\n');
            stack.clear();
        }

        System.out.println(sb);
    }
}
