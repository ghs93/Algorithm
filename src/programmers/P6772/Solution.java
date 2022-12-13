package programmers.P6772;

import java.util.Arrays;

/**
 * Programmers 6772. 스킬 체크 테스트 Level.2 - 2
 * @author hoseong
 * @category 쿼드압축 후 개수 세기
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arr = new int[][] {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		int[][] arr = new int[][] {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
		System.out.println(Arrays.toString(solution(arr)));

	}
			
	public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        dfs(arr.length, 0, 0, answer, arr);
        
        return answer;
    }
	
	public static void dfs(int size, int r, int c, int[] result, int[][] arr) {
		int s = arr[r][c];
		
		if(size == 1) {
			result[s]++;
			
			return;
		}
		
		boolean check = true;
		loop: for (int dr = r, rSize = r + size; dr < rSize; dr++) {
			for (int dc = c, cSize = c + size; dc < cSize; dc++) {
				if(s != arr[dr][dc]) {
					check = false;
					break loop;
				}
			}
		}
		
		if(check) {
			result[s]++;
			
		} else {
			int half = size / 2;
			dfs(half, r, c, result, arr);
			dfs(half, r, c + half, result, arr);
			dfs(half, r + half, c, result, arr);
			dfs(half, r + half, c + half, result, arr);
		}
	}
}
