package swea.P5648;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * SWEA 5648. 원자 소멸 시뮬레이션 
 * @author hoseong
 * @category 구현, BFS
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
    }
 
    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T;
        T = Integer.parseInt(br.readLine());
 
        for(int tc = 1; tc <= T; tc++)
        {
            int N = Integer.parseInt(br.readLine());
             
            ArrayList<Atom> atom = new ArrayList<>();
            boolean[][] map = new boolean[4001][4001];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                 
                int c = Integer.parseInt(st.nextToken()) * 2 + 2000;
                int r = Integer.parseInt(st.nextToken()) * 2 + 2000;
                int d = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                 
                atom.add(new Atom(r, c, d, e));
                map[r][c] = true;
            }
             
            int boom = 0;
            while(atom.size() > 1) {
                int size = atom.size() - 1;
                 
                for (int i = size; i >= 0; i--) {
                    Atom a = atom.get(i);
                    map[a.r][a.c] = false;
                     
                    int dr = a.r + dir[a.d][0];
                    int dc = a.c + dir[a.d][1];
                     
                    if(dr<0 || dr> 4000 || dc<0 || dc>4000) {
                        atom.remove(i);
                        continue;
                    }
                     
                    if(map[dr][dc]) {
                        a.isBoom = true;
                        int tempSize = atom.size();
                        for (int j = i+1; j <tempSize ; j++) {
                            Atom temp = atom.get(j);
                             
                            if(temp.r == dr && temp.c == dc)
                                temp.isBoom = true;
                        }
                    }
                     
                    map[dr][dc] = true;
                    a.r = dr;
                    a.c = dc;
                }
                 
                size = atom.size() - 1;
                for (int i = size; i >= 0; i--) {
                    Atom a = atom.get(i);
                     
                    if(a.isBoom) {
                        boom += a.e;
                        map[a.r][a.c] = false;
                        atom.remove(i);
                    }
                }
            }
             
            System.out.println("#" + tc + " " + boom);
        }
    }
}