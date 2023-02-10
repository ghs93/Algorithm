package baekjoon.P1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 1931. 회의실 배정 - 실버 1
 * @author hoseong
 * @category
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1])
                return a[0] - b[0];

            return a[1] - b[1];
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int cnt = 0;
        int endTime = 0;
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();

            if(tmp[0] >= endTime) {
                cnt++;
                endTime = tmp[1];
            }
        }

        System.out.println(cnt);
    }
}
