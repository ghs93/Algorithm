package swea.P5650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * SWEA 5650. 핀볼 게임 
 * @author hoseong
 * @category 구현, BFS
 */
public class Solution {
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }, map;
	static int max, N;
	static List<int[]>[] holeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			holeList = new ArrayList[5];
			for (int i = 0; i < 5; i++) {
				holeList[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if (6 <= map[i][j] && map[i][j] <= 10) {
						holeList[map[i][j] % 6].add(new int[] {i, j});
                    }
				}
			}
			
			max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 0) {
						for (int d = 0; d < 4; d++) {
							bfs(i, j, d);
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + max);
		}
	}
	
	private static void bfs(int r, int c, int d) {
		int result = 0;
		int dr = r;
		int dc = c;
		
		while(true) {
			dr += dir[d][0];
			dc += dir[d][1];
			
			if(dr<0 || dr>=N || dc<0 || dc>=N) {
				d = (d+2) % 4;
				result++;
				continue;
			}
			
			int block = map[dr][dc];
			//원점 또는 블랙홀인 경우 게임 끝
			if((r == dr && c == dc) || (block == -1)) {
				break;
				
			} else if (block == 0) {
				continue;
				
			} else if(block >= 1 && block <= 5) {
				d = hitBlock(block, d);
				result++;
				
			} else {
				int[] hole = findWormhole(dr, dc, block % 6);
				dr = hole[0];
				dc = hole[1];
			}
		}
		
		max = Math.max(max, result);
	}
	
	static int[] findWormhole(int r, int c, int num) {
        for (int i = 0; i < holeList[num].size(); i++) {
            int wr = holeList[num].get(i)[0];
            int wc = holeList[num].get(i)[1];
            if (wr == r && wc == c)
                continue;
            return new int[] { wr, wc };
        }
        return null;
    }
	
	// d - 0: ↑, 1: →, 2: ↓, 3: ←
	private static int hitBlock(int block, int d) {
		switch (d) {
		case 0:
			if (block == 1 || block == 4 || block == 5) {
				return 2;

			} else if (block == 2) {
				return 1;

			} else {
				return 3;
			}

		case 1:
			if (block == 1 || block == 2 || block == 5) {
				return 3;

			} else if (block == 3) {
				return 2;

			} else {
				return 0;
			}

		case 2:
			if (block == 2 || block == 3 || block == 5) {
				return 0;

			} else if (block == 1) {
				return 1;

			} else {
				return 3;
			}

		case 3:
			if (block == 3 || block == 4 || block == 5) {
				return 1;

			} else if (block == 1) {
				return 0;

			} else {
				return 2;
			}

		default:
			return d;
		}
	}
}