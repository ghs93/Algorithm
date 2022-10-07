package baekjoon.P17472;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 17472. 다리 만들기2 - 골드 1
 * @author hoseong
 * @category 구현, BFS, MST
 */
public class Main {
	static int N, M, map[][], parents[];
	static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static PriorityQueue<int[]> D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int m = Integer.parseInt(st.nextToken());

				map[i][j] = m == 0 ? m : -1; 
			}
		}
		
		setCountry(); // 섬 분리하기
		makeBridge(); // 다리 연결하기
		
		// 크루스칼 응용
		int dist = 0;
		for (int i = 1, size = D.size(); i < size; i++) {
			int[] bridge = D.poll();
			
			if(!union(bridge[0], bridge[1])) {
				dist += bridge[2];
			}				
		}
		
		// 모든 집합 부모노드로 바꾸기
		for (int i = 1, size = parents.length; i < size; i++) {
			find(i);
		}
		
		// 집합 수 구하기
		int group = 0, idx = parents[1];
		for (int i = 1, size = parents.length; i < size; i++) {
			if(idx != parents[i]) {
				group++;
			}
		}
		
		if(group > 0)
			System.out.println(-1);
		else
			System.out.println(dist);
	}

	// 모든 섬을 1번부터 N번까지의 번호로 바꾼다
	private static void setCountry() {
		int country = 1;
		Queue<int[]> q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == -1) {
					map[i][j] = country;
					q.add(new int[] {i, j});
					
					while(!q.isEmpty()) {
						int[] dr = q.poll();
						
						for (int d = 0; d < 4; d++) {
							int r = dr[0] + dir[d][0];
							int c = dr[1] + dir[d][1];
							
							if(r<0 || r>=N || c<0 || c>=M)
								continue;
							
							if(map[r][c] == 0)
								continue;
							
							if(map[r][c] == -1) {
								q.add(new int[] {r, c});
								map[r][c] = country;
							}
						}
					}
					
					country++;
				}
			}
		}
		
		// 구해진 섬의 개수로 union-find를 위해 parents 배열을 초기화한다.
		parents = new int[country];
		D = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		for (int i = 0; i < country; i++) {
			parents[i] = i;
		}
	}
	
	// 모든 섬을 연결하며 pq에 넣어서 정렬시킨다
	private static void makeBridge() {
		int size = parents.length;
		
		for (int l = 1; l <= size; l++) { //시작 섬 번호
			//완탐
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == l) {
						for (int d = 0; d < 4; d++) {
							int r = i;
							int c = j;
							int step = 0;
							
							while(true) {
								r += dir[d][0];
								c += dir[d][1];
								
								if(r<0 || r>=N || c<0 || c>=M || map[r][c] == l)
									break;
								
								if(map[r][c] != 0) {
									if(step <= 1)
										break;
									
									int g = map[r][c];
									D.add(new int[] {l, g, step});
									break;
								}
								
								step++;
							}
						}
					}
				}
			}
		}
	}
	
	private static boolean union(int a, int b) {
		int ar = find(a);
		int br = find(b);
		
		if(ar == br) return true;
		
		parents[br] = ar;
		return false;
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		
		return parents[a] = find(parents[a]);
	}
}