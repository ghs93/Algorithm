package baekjoon.P6571;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 백준 6571. 피보나치 수의 개수 - 실버 3
 * @author hoseong
 * @category 큰 수
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());

            BigInteger start = new BigInteger(st.nextToken());
            BigInteger end = new BigInteger(st.nextToken());

            if(start.compareTo(BigInteger.valueOf(0)) == 0 && end.compareTo(BigInteger.valueOf(0)) == 0) {
                break;
            }

            BigInteger fibo = BigInteger.valueOf(0);
            BigInteger before = BigInteger.valueOf(0);
            BigInteger current = BigInteger.valueOf(1);
            int cnt = 0;
            while (fibo.compareTo(end) <= 0) {
                fibo = current.add(before);
                before = current;
                current = fibo;

                if(fibo.compareTo(start) >= 0 && fibo.compareTo(end) <= 0)
                    cnt++;
            }

            sb.append(cnt).append('\n');
        }

        System.out.println(sb);
    }
}
