package baekjoon.P16235;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 16235. 나무 재테크 - 골드 3
 * @author hoseong
 * @category 구현
 */
public class Main {
	static class Tree implements Comparable<Tree>{
		int r, c, age;

		public Tree(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
	
	static int N, M, K, map[][], A[][];
	static PriorityQueue<Tree> trees;
	static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(map[i], 5);
		}
		
		A = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		trees = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			trees.add(new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 0; i < K; i++) {
			springSummer();
			fall();
			winter();
		}
		
		System.out.println(trees.size());
	}
	
	private static void springSummer() {
		Queue<Tree> bitamin = new LinkedList<>();
		PriorityQueue<Tree> temp = new PriorityQueue<>();
		
		while(!trees.isEmpty()) {
			Tree tree = trees.poll();
			
			if(map[tree.r][tree.c] >= tree.age) {
				map[tree.r][tree.c] -= tree.age;
				tree.age++;
				temp.add(tree);
				
			} else {
				bitamin.add(new Tree(tree.r, tree.c, tree.age / 2));
			}
		}
		trees = temp;
		
		while(!bitamin.isEmpty()) {
			Tree t = bitamin.poll();
			map[t.r][t.c] += t.age;
		}
	}
	
	private static void fall() {
		PriorityQueue<Tree> temp = new PriorityQueue<>();
		
		while(!trees.isEmpty()) {
			Tree tree = trees.poll();
			
			if(tree.age % 5 == 0) {
				for (int j = 0; j < 8; j++) {
					int r = tree.r + dir[j][0];
					int c = tree.c + dir[j][1];
					
					if(r<=0 || r>N || c<=0 || c>N) continue;
					temp.add(new Tree(r, c, 1));
				}
			}
			
			temp.add(tree);
		}
		
		trees = temp;
	}

	private static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] += A[i][j];
			}
		}
	}
}