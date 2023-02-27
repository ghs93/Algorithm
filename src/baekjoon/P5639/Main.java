package baekjoon.P5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 5639. 이진 검색 트리 - 골드 5
 * @author hoseong
 * @category DFS
 */
public class Main {
    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }

        public void insert(int n) {
            if (n > num) {
                if (right == null)
                    right = new Node(n);
                else
                    right.insert(n);

            } else {
                if (left == null)
                    left = new Node(n);
                else
                    left.insert(n);
            }
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String node = br.readLine();

            if (node == null || node.equals("")) break;
            root.insert(Integer.parseInt(node));
        }

        postOrder(root);
        System.out.println(sb);
    }

    static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.num).append('\n');
    }
}
