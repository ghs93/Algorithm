package swea.P2930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 2930. 힙
 * @author hoseong
 * @category 구현
 */
public class Solution2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append('#').append(tc).append(' ');
            int N = Integer.parseInt(br.readLine());

            Heap heap = new Heap();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int exec = Integer.parseInt(st.nextToken());
                if (exec == 1) {
                    int add = Integer.parseInt(st.nextToken());
                    heap.add(add);

                } else {
                    if (heap.isEmpty()) {
                        sb.append(-1).append(' ');

                    } else {
                        int add = heap.poll();
                        sb.append(add).append(' ');
                    }
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static class Heap {
        int[] arr;
        int cnt;

        Heap() {
            arr = new int[100001];
            cnt = 0;
        }

        public void add(int num) {
            arr[++cnt] = num;

            int now = cnt;
            while (now > 1) {
                int parent = getParent(now);

                if (arr[now] > arr[parent]) {
                    int tmp = arr[parent];
                    arr[parent] = arr[now];
                    arr[now] = tmp;
                    now = parent;

                } else {
                    break;
                }
            }
        }

        public int poll() {
            int max = arr[1];
            arr[1] = arr[cnt];
            arr[cnt] = 0;
            cnt--;
            sort();

            return max;
        }

        public boolean isEmpty() {
            return cnt == 0;
        }

        public int getParent(int num) {
            return num / 2;
        }

        public int getLeft(int num) {
            return num * 2;
        }

        public int getRight(int num) {
            return num * 2 + 1;
        }

        public void sort() {
            int now = 1;

            while (getRight(now) <= cnt) {
                int larger = now;
                int left = getLeft(now);
                int right = getRight(now);

                if (arr[left] > arr[larger]) {
                    larger = left;
                }

                if (arr[right] > arr[larger]) {
                    larger = right;
                }

                if (larger != now) {
                    int tmp = arr[now];
                    arr[now] = arr[larger];
                    arr[larger] = tmp;
                    now = larger;

                } else {
                    break;
                }
            }
        }
    }
}
