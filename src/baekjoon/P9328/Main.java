package baekjoon.P9328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 9328. 열쇠 - 골드 1 @author hoseong @category
 */
public class Main {
	static int H, W;
	static ArrayList<int[]> doors;
	static HashSet<Character> keys;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			doors = new ArrayList<>();
			keys = new HashSet<>();

			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < W; j++) {
					char d = st.nextToken().charAt(0);
					map[i][j] = d;

					//외곽이고 출발할 수 있는 곳
					if ((i == 0 || i == (H - 1)) && d != '*') {
						doors.add(new int[] { i, j });

					} else if ((j == 0 || j == (W - 1)) && d != '*') {
						doors.add(new int[] { i, j });
					}
				}
			}
			
			String ks = br.readLine();
			for (int i = 0; i < ks.length(); i++) {
				keys.add(ks.charAt(i));
			}
			
			sb.append(bfs()).append('\n');
		}

	}

	private static int bfs() {
		int cnt = 0;
		
		boolean[][] visited = new boolean[H][W];
		Queue<int[]> q = new ArrayDeque<>();
		
		for (int i = 0; i < doors.size(); i++) {
			int[] door = doors.get(i);
			q.add(door);
			visited[door[0]][door[1]] = true;
			
			
		}
		
		return cnt;
	}

}
