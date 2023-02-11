package baekjoon.P7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 7662. 이중 우선순위 큐 - 골드 4
 * @author hoseong
 * @category 우선순위 큐, HashMap
 */
public class Main {
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        // I = 73
        // D = 68
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine());

            min = new PriorityQueue<>();
            max = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                int id = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if(id == 73) {
                    max.add(num);
                    min.add(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);

                } else {
                    if (map.size() == 0) continue;

                    removeNum(num == 1);
                }
            }

            if (map.isEmpty())
                sb.append("EMPTY").append('\n');
            else {
                int m = removeNum(true);
                sb.append(m).append(' ').append(!map.isEmpty() ? removeNum(false) : m).append('\n');
            }
        }

        System.out.println(sb);
    }

    static int removeNum(boolean isMax) {
        int num;

        while (true) {
            num = isMax ? max.poll() : min.poll();
            int cnt = map.getOrDefault(num, 0);

            if (cnt == 0) continue;

            if (cnt == 1) map.remove(num);
            else map.put(num, cnt - 1);

            break;
        }

        return num;
    }
}
