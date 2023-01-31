package baekjoon.P2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 백준 2108. 통계학 - 실버 3
 * @author hoseong
 * @category 구현, 정렬
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> sortArr = new LinkedList<>();
        int[] freArr = new int[8001];

        int maxFre = 0;
        int min = 4001, max = -4001;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            freArr[num+4000]++;
            sortArr.add(num);

            maxFre = Math.max(maxFre, freArr[num+4000]);
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int cnt = 0, fre = 0;
        for (int i = 0; i <= 8000; i++) {
            if(cnt == 2)
                break;

            if(maxFre == freArr[i]) {
                fre = i - 4000;
                cnt++;
            }
        }

        Collections.sort(sortArr);
        System.out.println(Math.round((float)sum/N));
        System.out.println(sortArr.get(N/2));
        System.out.println(fre);
        System.out.println(max - min);
    }
}
