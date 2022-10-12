package swea.P5653;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * SWEA 5653. 줄기세포배양 
 * @author hoseong
 * @category 구현, 델타
 */
public class Solution {
	static class Cell implements Comparable<Cell> {
		int r, c, life, time;

		public Cell(int r, int c, int life) {
			this.r = r;
			this.c = c;
			this.life = life;
			time = 0;
		}

		@Override
		public int compareTo(Cell o) {
			return o.life - this.life;
		}
	}
	
	static int SIZE = 650;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			boolean[][] yonggi = new boolean[SIZE][SIZE];
			PriorityQueue<Cell> cells = new PriorityQueue<>();
			PriorityQueue<Cell> temp = new PriorityQueue<>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int life = Integer.parseInt(st.nextToken());
					
					if(life>0) {
						cells.add(new Cell(i + 300, j + 300, life));
						yonggi[i+300][j+300] = true;
					}
				}
			}
			
			int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
			for (int i = 1; i <= K; i++) {
				for (int j = 0, size = cells.size(); j < size; j++) {
					Cell cell = cells.poll();
					
					//활성
					if(cell.life - cell.time <= 0) {
						for (int d = 0; d < 4; d++) {
							int r = cell.r + dir[d][0];
							int c = cell.c + dir[d][1];
							
							if(yonggi[r][c]) continue;
							
							yonggi[r][c] = true;
							temp.add(new Cell(r, c, cell.life));
						}
					}
					
					cell.time++;
					
					//소멸
					if(cell.life * 2 == cell.time) {
						continue;
					}
					
					temp.add(cell);
				}
				
				cells.addAll(temp);
				temp.clear();
			}
			
			System.out.println("#" + tc + " " + cells.size());
		}
	}
}
