package baekjoon.P9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9935. 문자열 폭발 - 골드 4
 * @author hoseong
 * @category 문자열
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String boom = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0, size = str.length(); i < size; i++) {
            sb.append(str.charAt(i));

            if (sb.length() >= boom.length()) {
                boolean isSame = true;

                for (int j = 0, bSize = boom.length(); j < bSize; j++) {
                    char c = sb.charAt(sb.length() - bSize + j);

                    if (c != boom.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    sb.delete(sb.length() - boom.length(), sb.length());
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}
