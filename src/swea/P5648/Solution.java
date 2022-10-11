package swea.P5648;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * SWEA 5648. 원자 소멸 시뮬레이션 
 * @author hoseong
 * @category 
 */
public class Solution {
	static class Atom {
		int r, c, d, e;
		boolean isBoom;

		public Atom(int r, int c, int d, int e) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.e = e;
			
			isBoom = false;
		}

		@Override
		public boolean equals(Object obj) {
			Atom a = (Atom) obj;
			
			return this.r == a.r && this.c == a.c;
		}
	}

	static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
	static int[] check = {1, 0, 3, 2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T;
		T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++)
		{
			int N = Integer.parseInt(br.readLine());
			
			ArrayList<Atom> atom = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int c = Integer.parseInt(st.nextToken()) + 1000;
				int r = Integer.parseInt(st.nextToken()) + 1000;
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				atom.add(new Atom(r, c, d, e));
			}
			
			int boom = 0;
			while(!atom.isEmpty()) {
				int size = atom.size() - 1;
				
				for (int i = size; i >= 0; i--) {
					Atom a = atom.get(i);
					
					int dr = a.r + dir[a.d][0];
					int dc = a.c + dir[a.d][1];
					
					if(dr<0 || dr> 2000 || dc<0 || dc>2000) {
						atom.remove(i);
						continue;
					}
					
					Atom na = new Atom(dr, dc, a.d, a.e);
					if(atom.contains(na)) {
						int idx = atom.indexOf(na);
						Atom da = atom.get(idx);
						if(a.d == check[da.d] || da.isBoom) {
							a.isBoom = true;
							a.r = dr;
							a.c = dc;
							
							atom.get(idx).isBoom = true;
							
						} else {
							atom.set(i, na);
						}
						
					} else {
						atom.set(i, na);
					}
				}
				
				size = atom.size() - 1;
				for (int i = size; i >= 0; i--) {
					Atom a = atom.get(i);
					
					if(a.isBoom) {
						boom += a.e;
						atom.remove(i);
					}
				}
			}
			
			System.out.println("#" + tc + " " + boom);
		}
	}
}