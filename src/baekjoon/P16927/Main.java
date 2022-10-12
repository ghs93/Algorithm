package baekjoon.P16927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 16927. 배열 돌리기 2 - 골드 5
 * 
 * @author hoseong
 * @category 구현
 */
public class Main {
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
        int K = Math.min(N, M)/2;
        for (int j = 1; j <= K; j++) {
        	int cycle = ((N - (j-1))-j) * 2 + ((M - (j-1))-j) * 2;
        	int mr = R % cycle;
        	
        	for (int i = 1; i <= mr; i++) {
				int temp = map[j][j];
				int r = j;
				int c = j;
				
				for (int d = 0; d < 4; d++) {
					while(true) {
						int dr = r + dir[d][0];
						int dc = c + dir[d][1];
						
						if(dr<j || dr>N-(j-1) || dc<j || dc>M-(j-1)) break;
						
						if(dr == j && dc == j) {
							map[r][c] = temp;
							break;
						}
						
						map[r][c] = map[dr][dc];
						r = dr;
						c = dc;
					}
				}
			}
		}
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
        
        System.out.println(sb);
	}
}
