package baekjoon.P1613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1613. 역사 - 골드 3
 * @author hoseong
 * @category 플로이드-워셜
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[][] front = new boolean[N+1][N+1];
		boolean[][] rear = new boolean[N+1][N+1];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			front[from][to] = true;
			rear[to][from] = true;
		}
		
		for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i != j && front[i][k] != false && front[k][j] != false) {
                        front[i][j] = true;
                    }
                    if (i != j && rear[i][k] != false && rear[k][j] != false) {
                        rear[i][j] = true;
                    }
                }
            }
        }
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				front[i][j] = front[i][j] | rear[i][j];
			}
		}
		
		int S = Integer.parseInt(br.readLine());
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(front[from][to] && rear[to][from]) {
				System.out.println(-1);
				
			} else if (front[from][to] && !rear[to][from]) {
				System.out.println(1);
				
			} else if (!front[from][to] && !rear[to][from]) {
				System.out.println(0);
			}
		}
	}
}