package swea.P5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA 5656. 벽돌 깨기
 * @author hoseong
 * @category 구현, 중복순열, BFS
 */
public class Solution {
	static int N, W, H, map[][], min;
	static int[] gusle;
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			
			gusle = new int[N];
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			per(0);
			System.out.println("#" + test_case + " " + min);
		}
	}

	//중복순열을 통한 돌 던질 col 구하기
	private static void per(int cnt) {
		if(cnt == N) {
			//map 복사
			int[][] temp = new int[H][W];
			for (int i = 0; i < H; i++) {
				temp[i] = map[i].clone();
			}
			
			//구슬 던지고 중력 적용
			for (int i = 0; i < N; i++) {
				if(dropGusle(gusle[i], temp))
					dropBlock(temp);
			}
			
			min = Math.min(min, countingBlock(temp));
			return;
		}
		
		for (int i = 0; i < W; i++) {
			if(min == 0)
				break;
			
			gusle[cnt] = i;
			per(cnt+1);
		}
	}
	
	//구슬 떨어뜨리기
	private static boolean dropGusle(int g, int[][] block) {
		int r=0, c=g;
		
		while(block[r][c] == 0) {
			r++;
			
			if(r == H)
				return false;
		}
		
		//r, c에서 벽 부수기
		deleteBlock(r, c, block);
		return true;
	}

	//벽 부수기 - BFS 사용
	private static void deleteBlock(int r, int c, int[][] block) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] target = q.poll();
			
			int step = block[target[0]][target[1]];
			block[target[0]][target[1]] = 0;
			
			for (int i = 0; i < 4; i++) {
				int dr = target[0];
				int dc = target[1];
				
				for (int j = 1; j < step; j++) {
					dr += dir[i][0];
					dc += dir[i][1];
					
					if(dr<0 || dr>=H || dc<0 || dc>=W)
						break;
					
					if(block[dr][dc] > 1) {
						q.add(new int[] {dr, dc});
						
					} else {
						block[dr][dc] = 0;
					}
				}
			}
		}
	}
	
	//중력작용
	private static void dropBlock(int[][] block) {
		for (int i = W-1; i >= 0; i--) {
			for (int j = H-1; j >= 0; j--) {
				if(block[j][i] > 0) {
					for (int k = H-1; k >= j; k--) {
						if(block[k][i] == 0) {
							block[k][i] = block[j][i];
							block[j][i] = 0;
							break;
						}
					}
				}
			}
		}
	}
	
	//벽돌 개수 파악
	private static int countingBlock(int[][] block) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(block[i][j] > 0)
					cnt++;
			}
		}
		
		return cnt;
	}
}