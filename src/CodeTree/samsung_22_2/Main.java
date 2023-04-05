package CodeTree.samsung_22_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static Belt[] belts;
    static int[] size;
    static int[] location;

    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        int p = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < p; tc++) {
            st = new StringTokenizer(br.readLine());

            int cs = Integer.parseInt(st.nextToken());
//            System.out.println(cs);
            switch (cs) {
                case 100:
                    n = Integer.parseInt(st.nextToken()); //belt
                    m = Integer.parseInt(st.nextToken()); //product

                    init(st);
                    break;

                case 200:
                    allMove(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    break;

                case 300:
                    changeFront(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    break;

                case 400:
                    divideProduct(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    break;

                case 500:
                    getProductInfo(Integer.parseInt(st.nextToken()));
                    break;

                case 600:
                    getBeltInfo(Integer.parseInt(st.nextToken()));
                    break;
            }
//            System.out.println(Arrays.toString(location));
        }

        System.out.println(sb);
    }

    static void init(StringTokenizer st) {
        belts = new Belt[n+1];
        size = new int[n+1];
        location = new int[m+1];

        for (int i = 0; i <= n; i++) {
            belts[i] = new Belt();
        }

        for (int i = 1; i <= m; i++) {
            int b = Integer.parseInt(st.nextToken());

            location[i] = b;
            Product product = new Product(i);
            if (belts[b].header.next == null) {
                belts[b].header.next = belts[b].rear = product;

            } else {
                belts[b].rear.next = product;
                belts[b].rear = product;
            }

            size[b]++;
        }
    }

    static void allMove(int src, int dst) {
        if (belts[src].header.next == null) {
            appendAnswer(size[dst]);
            return;
        }

        Product tmp = belts[src].header.next;
        location[tmp.num] = dst;
        while (tmp.next != null) {
            tmp = tmp.next;
            location[tmp.num] = dst;
        }

        belts[src].rear.next = belts[dst].header.next;
        belts[dst].header.next = belts[src].header.next;

        belts[src].header.next = null;
        belts[src].rear = null;

        size[dst] += size[src];
        size[src] = 0;

        appendAnswer(size[dst]);
    }

    static void changeFront(int src, int dst) {
        if (size[src] == 0 && size[dst] == 0) {
            appendAnswer(0);
            return;
        }

        if (belts[src].header.next == null) {
            location[belts[dst].header.next.num] = src;
            belts[src].header.next = belts[src].rear = belts[dst].header.next;
            belts[dst].header.next = belts[dst].header.next.next;

            size[src]++;
            size[dst]--;
            appendAnswer(size[dst]);

        } else if (belts[dst].header.next == null) {
            location[belts[src].header.next.num] = dst;
            belts[dst].header.next = belts[dst].rear = belts[src].header.next;
            belts[src].header.next = belts[src].header.next.next;

            size[src]--;
            size[dst]++;
            appendAnswer(size[dst]);

        } else {
            location[belts[dst].header.next.num] = src;
            location[belts[src].header.next.num] = dst;

            Product tmp = new Product(0);
            tmp.next = belts[dst].header.next.next;
            belts[dst].header.next.next = belts[src].header.next.next;
            belts[src].header.next.next = tmp.next;

            tmp.next = belts[dst].header.next;
            belts[dst].header.next = belts[src].header.next;
            belts[src].header.next = tmp.next;

            appendAnswer(size[dst]);
        }
    }

    static void divideProduct(int src, int dst) {
        if (size[src] < 2) {
            appendAnswer(size[dst]);
            return;
        }

        int s = size[src] / 2;

        Product srcTemp = belts[src].header.next;
        Product dstTemp = belts[dst].header.next;

        location[srcTemp.num] = dst;
        for (int i = 1; i < s; i++) {
            srcTemp = srcTemp.next;
            location[srcTemp.num] = dst;
        }

        belts[dst].header.next = belts[src].header.next;
        belts[src].header.next = srcTemp.next;
        srcTemp.next = dstTemp;

        size[src] -= s;
        size[dst] += s;

        appendAnswer(size[dst]);
    }

    static void getProductInfo(int num) {
        int src = location[num];

        Product tmp = belts[src].header.next;

        int a = -1;
        int b = -1;

        if (tmp.num == num) {
            b = tmp.next == null ? -1 : tmp.next.num;
            System.out.println("num: " + num + ", a: " + a + ", b: " + b + ", ans: " + (a + (2 * b)));
            appendAnswer(a + (2 * b));
            return;
        }

        Product front = null;
        while (tmp.num != num) {
            front = tmp;
            tmp = tmp.next;
        }

        a = front.num;
        b = tmp.next == null ? -1 : tmp.next.num;
        System.out.println("num: " + num + ", a: " + a + ", b: " + b + ", ans: " + (a + (2 * b)) + ", tmp: " + tmp.num + ", next: " + (tmp.next == null ? -1 : tmp.next.num));
        appendAnswer(a + (2 * b));
    }

    static void getBeltInfo(int num) {
        if (belts[num].header.next == null) {
            appendAnswer(-3);
            return;
        }

        int a = belts[num].header.next.num;
        int b = belts[num].rear.num;
        int c = size[num];
        appendAnswer(a + (2 * b) + (3 * c));
    }

    static void appendAnswer(int answer) {
        sb.append(answer).append('\n');
    }

    static class Product {
        int num;
        Product next;

        Product(int num) {
            this.num =  num;
            this.next = null;
        }
    }

    static class Belt {
        Product header;
        Product rear;

        Belt() {
            this.header = new Product(-1);
            this.rear = null;
        }
    }
}

