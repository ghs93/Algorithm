package baekjoon.P11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 11403. 경로 찾기 - 실버 1
 * @author hoseong
 * @category 플로이드-워셜
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if((map[i][k] & map[k][j]) == 1)
						map[i][j] = 1;
				}
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int[] mp : map) {
			for (int m : mp) {
				sb.append(m).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}