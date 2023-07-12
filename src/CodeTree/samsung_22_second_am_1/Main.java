package CodeTree.samsung_22_am_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * CodeTree. 싸움땅
 * @author hoseong
 * @category Simulation
 */
public class Main {
    static class Man {
        int x;
        int y;
        int dir;
        int power;
        int gun;
        int num;

        Man(int x, int y, int dir, int power, int num) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.power = power;
            this.num = num;
        }
    }

    static int N, M, K;
    static PriorityQueue<Integer>[][] guns;
    static Man[] mans;
    static int[] score;
    static int[][] manCnt;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[] reverse = {2, 3, 0, 1};
    static int[] rotate = {1, 2, 3, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 격차 크기
        M = Integer.parseInt(st.nextToken()); // 플레이어 수
        K = Integer.parseInt(st.nextToken()); // 라운드 수

        guns = new PriorityQueue[N+1][N+1];
        manCnt = new int[N+1][N+1];
        mans = new Man[M+1];
        score = new int[M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                guns[i][j] = new PriorityQueue<>(Collections.reverseOrder());
                guns[i][j].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            mans[i] = new Man(x, y, d, s, i);
            manCnt[x][y] = i;
        }

        for (int i = 0; i < K; i++) {
            for (int j = 1; j <= M; j++) {
                move(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            sb.append(score[i]).append(' ');
        }

        System.out.println(sb);
    }

    static void move(int num) {
        Man man = mans[num];

        int dr = man.x + dir[man.dir][0];
        int dc = man.y + dir[man.dir][1];

        if (!check(dr, dc)) {
            man.dir = reverse[man.dir];
            dr = man.x + dir[man.dir][0];
            dc = man.y + dir[man.dir][1];
        }

        manCnt[man.x][man.y] = 0;
        man.x = dr;
        man.y = dc;

        if (manCnt[dr][dc] > 0) {
            fight(man, mans[manCnt[dr][dc]]);

        } else if (!guns[dr][dc].isEmpty() && guns[dr][dc].peek() > man.gun) {
            guns[dr][dc].add(man.gun);
            man.gun = guns[dr][dc].poll();
            manCnt[dr][dc] = num;

        } else {
            manCnt[dr][dc] = num;
        }
    }

    static void fight(Man srcMan, Man dstMan) {
        int sp = srcMan.power + srcMan.gun;
        int dp = dstMan.power + dstMan.gun;

        if (sp == dp) {
            loser(srcMan.power > dstMan.power ? dstMan : srcMan);
            winner(srcMan.power > dstMan.power ? srcMan : dstMan, 0);

        } else {
            loser(sp > dp ? dstMan : srcMan);
            winner(sp > dp ? srcMan : dstMan, Math.abs(sp - dp));
        }
    }

    static void winner(Man man, int sc) {
        score[man.num] += sc;
        manCnt[man.x][man.y] = man.num;

        if (!guns[man.x][man.y].isEmpty() && guns[man.x][man.y].peek() > man.gun) {
            guns[man.x][man.y].add(man.gun);
            man.gun = guns[man.x][man.y].poll();
        }
    }

    static void loser(Man man) {
        guns[man.x][man.y].add(man.gun);
        man.gun = 0;

        for (int d = 0; d < 4; d++) {
            int dr = man.x + dir[man.dir][0];
            int dc = man.y + dir[man.dir][1];

            if (check(dr, dc) && manCnt[dr][dc] == 0) {
                man.x = dr;
                man.y = dc;
                break;
            }

            man.dir = rotate[man.dir];
        }

        if (!guns[man.x][man.y].isEmpty() && guns[man.x][man.y].peek() > 0) {
            man.gun = guns[man.x][man.y].poll();
        }

        manCnt[man.x][man.y] = man.num;
    }

    static boolean check(int r, int c) {
        boolean isCheck = true;

        if (r <= 0 || r > N || c <= 0 || c > N)
            isCheck = false;

        return isCheck;
    }
}
