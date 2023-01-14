package baekjoon.P16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 16953. A -> B - 실버 2
 * @author hoseong
 * @category DFS
 */
public class Main {
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        aToB(A, B, 1);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void aToB(long a, long b, int cnt) {
        if(a > b) return;

        if(a == b) {
            result = Math.min(result, cnt);
            return;
        }

        aToB(a * 10 + 1, b, cnt + 1);
        aToB(a * 2, b, cnt + 1);
    }
}
