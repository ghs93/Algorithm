package baekjoon.P11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 11651. 좌표 정렬하기 2 - 실버 5
 * @author hoseong
 * @category 정렬
 */
public class Main {
    static class Position implements Comparable<Position> {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Position o) {
            if(this.y == o.y) {
                return Integer.compare(this.x, o.x);

            }

            return Integer.compare(this.y, o.y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Position> q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            q.add(new Position(x, y));
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Position position = q.poll();

            sb.append(position.x).append(' ').append(position.y).append('\n');
        }

        System.out.println(sb);
    }
}
