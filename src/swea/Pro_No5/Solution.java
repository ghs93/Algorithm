package swea.Pro_No5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * SWEA Pro No.5 수열 편집
 * @author hoseong
 * @category LinkedList
 */
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            LinkedList<Integer> arr = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            int index = 0;
            int num = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                char bash = st.nextToken().charAt(0);
                switch (bash) {
                    case 'I':
                        index = Integer.parseInt(st.nextToken());
                        num = Integer.parseInt(st.nextToken());

                        arr.add(index, num);
                        break;
                    case 'D':
                        index = Integer.parseInt(st.nextToken());

                        arr.remove(index);
                        break;
                    case 'C':
                        index = Integer.parseInt(st.nextToken());
                        num = Integer.parseInt(st.nextToken());

                        arr.set(index, num);
                        break;
                }
            }

            sb.append('#').append(test_case).append(' ').append(L >= arr.size() ? -1 : arr.get(L)).append('\n');
        }

        System.out.println(sb);
    }
}
