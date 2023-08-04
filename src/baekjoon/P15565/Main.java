package baekjoon.P15565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 백준 15565. 귀여운 라이언 - 실버 1
 * @author hoseong
 * @category 슬라이딩 윈도우
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int doll = Integer.parseInt(st.nextToken());
            
            if (doll == 1)
                arr.add(i);
        }
        
        if (arr.size() < k) {
            System.out.println(-1);
            return;
        }
        
        int min = n;
        for (int i = 0, size = arr.size(); i <= size - k; i++) {
            min = Math.min(min, arr.get(i+k-1) - arr.get(i) + 1);
        }

        System.out.println(min);
    }
}
