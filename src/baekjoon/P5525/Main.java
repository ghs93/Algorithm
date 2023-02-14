package baekjoon.P5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 5525. IOIOI - 실버 1
 * @author hoseong
 * @category 문자열
 */
public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= N * 2; i++) {
            sb.append(i % 2 == 0 ? 'I' : 'O');
        }

        String ioi = sb.toString();
        int cnt = 0;

        int size = M - (2 * N);
        for (int i = 0; i <= size; i++) {
            if(S.charAt(i) == ioi.charAt(0) && check(i, S, ioi)) {
                cnt++;

                int tmp = i + (2 * N) + 1;
                while (tmp + 1 < M) {
                    if(S.charAt(tmp) == 'O' && S.charAt(tmp + 1) == 'I') {
                        cnt++;
                        tmp += 2;

                    } else {
                        break;
                    }
                }

                i = tmp - 1;
            }
        }

        System.out.println(cnt);
    }

    static boolean check(int p, String s, String ioi) {
        int size = p + (2 * N);
        int j = 0;

        if(size >= M) return false;

        for (int i = p; i <= size; i++) {
            if(s.charAt(i) != ioi.charAt(j++))
                return false;
        }

        return true;
    }
}
