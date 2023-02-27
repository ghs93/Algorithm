package swea.P1288;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SWEA 1288. 새로운 불면증 치료법
 * @author hoseong
 * @category 나머지 연산
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[10];

            int i = 1;
            int cnt = 0;
            int result = 0;
            while (cnt < 10) {
                int tmp = i * N;
                result = tmp;
                while (tmp != 0) {
                    int t = tmp % 10;
                    tmp /= 10;

                    if(arr[t] == 0) {
                        arr[t]++;
                        cnt++;
                    }
                }

                i++;
            }

            sb.append('#').append(test_case).append(' ').append(result).append('\n');
        }

        System.out.println(sb);
    }
}
