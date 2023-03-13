package baekjoon.P2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 백준 2239. 스도쿠 - 골드 4
 * @author hoseong
 * @category 구현, 백트래킹
 */
public class Main {
    static class Position {
        int r, c;

        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N = 9;
    static int[][] map = new int[N+1][N+1];
    static ArrayList<Position> positions = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();

            for (int j = 1; j <= N; j++) {
                int at = line.charAt(j-1) - 48;
                map[i][j] = at;

                if (at == 0) positions.add(new Position(i, j));
            }
        }

        dfs(0, 0, positions.size());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                sb.append(map[i][j]);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static boolean dfs(int start, int n, int size) {
        if (n == size) {
            return true;
        }

        boolean isMake = false;
        Position position = positions.get(start);

        for (int j = 1; j <= N; j++) {
            if (check(j, position)) {
                map[position.r][position.c] = j;

                isMake = dfs(start+1, n+1, size);
            }

            if (isMake) return true;

            map[position.r][position.c] = 0;
        }

        return false;
    }

    static boolean check(int at, Position position) {
        for (int i = 1; i <= N; i++) {
            if (i != position.r && map[i][position.c] == at) return false;
            if (i != position.c && map[position.r][i] == at) return false;
        }

        int r = 0, c = 0;
        if (position.r <= 3) r = 1;
        else if (position.r <= 6) r = 4;
        else r = 7;

        if (position.c <= 3) c = 1;
        else if (position.c <= 6) c = 4;
        else c = 7;

        for (int i = r; i <= r+2; i++) {
            for (int j = c; j <= c+2; j++) {
                if (i != position.r && j != position.c && map[i][j] == at) return false;
            }
        }

        return true;
    }
}
