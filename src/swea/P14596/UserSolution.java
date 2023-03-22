package swea.P14596;

import java.util.ArrayList;

/**
 * SWEA 14596. 섬지키기
 * @author hoseong
 * @category Hash, BFS
 */
class UserSolution
{
    public class Block {
        int r;
        int c;
        boolean isHorizontal;
        boolean isReverse;

        Block(int r, int c, boolean isHorizontal, boolean isReverse) {
            this.r = r;
            this.c = c;
            this.isHorizontal = isHorizontal;
            this.isReverse = isReverse;
        }
    }

    final int MAX_N = 20;
    final int MAX_M = 9999;

    int[][] init; // 초기의 섬 모양
    int[][] modify; // 블록을 설치했을때 섬 모양
    int n;
    ArrayList<Block>[] blocks; // 블록의 hash 값

    /**
     * 섬은 N x N 크기의 정사각형 모양이며, 1 x 1 크기의 정사각형 모양인 지역들로 이루어져 있다.
     * 각 지역의 고도는 아래와 같다.
     * @param N 섬의 한 변의 길이 (5 ≤ N ≤ 20)
     * @param mMap 섬의 각 지역의 고도 (1 ≤ mMap[][] ≤ 5)
     */
    public void init(int N, int mMap[][])
    {
        n = N;
        init = new int[N+2][N+2];
        modify = new int[N+2][N+2];
        blocks = new ArrayList[MAX_M];

        for (int i = 0; i <= MAX_M; i++) {
            blocks[i] = new ArrayList<>();
        }

        // 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                init[i+1][j+1] = modify[i+1][j+1] = mMap[i][j];
            }
        }

        //Hash 만들기
        for (int bl = 2; bl <= 5; bl++) { // block 길이
            // 가로
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j + bl - 1 <= N; j++) {
                    int hash = 0;
                    for (int k = j; k < j + bl; k++) {
                        hash = hash * 10 + (mMap[i][k] - mMap[i][k+1] + 5);
                    }
                    blocks[hash].add(new Block(i, j, true, false));

                    int reverseHash = 0;
                    for (int k = j + bl; k > j; k--) {
                        reverseHash = reverseHash * 10 + (mMap[i][k] - mMap[i][k-1] + 5);
                    }
                    blocks[reverseHash].add(new Block(i, j, true, true));
                }
            }

            // 세로
            for (int j = 1; j <= N; j++) {
                for (int i = 1; i + bl - 1 <= N; i++) {
                    int hash = 0;
                    for (int k = i; k < i + bl; k++) {
                        hash = hash * 10 + (mMap[k][j] - mMap[k+1][j] + 5);
                    }
                    blocks[hash].add(new Block(i, j, false, false));

                    int reverseHash = 0;
                    for (int k = i + bl; k > i; k--) {
                        reverseHash = reverseHash * 10 + (mMap[k][j] - mMap[k-1][j] + 5);
                    }
                    blocks[reverseHash].add(new Block(i, j, false, true));
                }
            }
        }
    }

    /**
     * 구조물 mStructure를 1개 설치했을 때, 나타날 수 있는 경우의 수를 반환한다.
     * 설치 지역이 모두 동일하면, 같은 경우로 취급한다.
     * 설치 지역이 1개라도 다르다면, 다른 경우로 취급한다.
     * 구조물 mStructure의 크기는 1 x M이며, 1 x 1 크기의 정사각형 모양인 부분들로 이루어져 있다.
     * @param M 구조물의 크기 (1 ≤ M ≤ 5)
     * @param mStructure 구조물의 각 부분의 높이 (1 ≤ mStructure[] ≤ 5)
     * @return 구조물을 설치할 수 있는 경우의 수
     */
    public int numberOfCandidate(int M, int mStructure[])
    {
        if (M == 1) {
            return n * n;
        }

        int hash = 0;
        for (int i = 0; i < M-1; i++) {
            hash = hash * 10 + (mStructure[i+1] - mStructure[i] + 5);
        }

        return blocks[hash].size();
    }

    /**
     * 해수면이 mSeaLevel만큼 상승하여도 바다에 잠기지 않고 남아있는 지역의 개수가 최대가 되도록 구조물 mStructure를 1개 설치했을 때, 그 개수를 반환한다.
     * 구조물 mStructure를 설치할 방법이 없는 경우에는, -1을 반환한다.
     * 구조물 mStructure의 크기는 1 x M이며, 1 x 1 크기의 정사각형 모양인 부분들로 이루어져 있다.
     * @param M 구조물의 크기 (1 ≤ M ≤ 5)
     * @param mStructure 구조물의 각 부분의 높이 (1 ≤ mStructure[] ≤ 5)
     * @param mSeaLevel 해수면의 상승 폭 (1 ≤ mSeaLevel ≤ 10)
     * @return 최대 지역 개수
     */
    public int maxArea(int M, int mStructure[], int mSeaLevel)
    {
        if (mSeaLevel == 1) {
            return n * n;
        }

        int result = -1;
        if (M == 1) {

        }

        return 0;
    }
}
