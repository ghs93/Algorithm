package programmers.P133501;

import java.util.Arrays;

/**
 * Programmers 133501. 야간 전술보행
 * @author hoseong
 * @category 
 */
public class Solution {
	public static void main(String[] args) {
		int result = solution(12, new int[][] {{7, 8}, {6, 2}, {11, 10}}, new int[][] {{2, 2}, {2, 4}, {3, 3}});
		System.out.println(result);
	}

	public static int solution(int distance, int[][] scope, int[][] times) {
        int answer = distance;
        
        int people = scope.length;
        for (int i = 0; i < people; i++) {
        	int t = times[i][0] + times[i][1];
        	int find = distance;
        	
        	Arrays.sort(scope[i]);
			for (int j = scope[i][0]; j <= scope[i][1]; j++) {
				int step = j % t;
				if(step != 0 && step <= times[i][0]) {
					find = j;
					break;
				}
			}
			
			answer = Math.min(answer, find);
		}
        
        return answer;
    }
}
