package swea.P1230;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * SWEA 1230. 암호문3
 * @author hoseong
 * @category LinkedList
 */
public class Solution {
    static StringTokenizer st;
    static LinkedList<Integer> list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src\\swea\\P1230\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            list = new LinkedList<>();
            
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                char bash = st.nextToken().charAt(0);

                switch (bash) {
                    case 'I':
                        insert();
                        break;
                    case 'D':
                        delete();
                        break;
                    case 'A':
                        add();
                        break;
                }
            }

            sb.append('#').append(test_case).append(' ');
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void insert() {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int i = x, cnt = x+y; i < cnt; i++) {
            list.add(i, Integer.parseInt(st.nextToken()));
        }
    }

    static void delete() {
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        for (int i = 0; i < y; i++) {
            list.remove(x);
        }
    }

    static void add() {
        int y = Integer.parseInt(st.nextToken());

        for (int i = 0; i < y; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
    }
}
