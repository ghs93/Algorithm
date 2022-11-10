package programmers.P134239;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Programmers 134239. 우박수열 정적분
 * @author hoseong
 * @category 구현
 */
public class Solution {

	public static void main(String[] args) {
		double[] result = solution(5, new int[][] {{0, 0}, {0, -1}, {2, -3}, {3, -3}, {5, 0}});
		System.out.println(Arrays.toString(result));
	}

	public static double[] solution(int k, int[][] ranges) {
        double[] answer;
        
        ArrayList<int[]> arr = new ArrayList<>();
        arr.add(new int[] {0, k});
        
        int i = 1;
        while(true) {
        	if(k == 1) {
        		break;
        	}
        	
        	if(k % 2 == 0) {
        		k /= 2;
        		arr.add(new int[] {i++, k});
        		
        	} else {
        		k = (k*3) + 1;
        		arr.add(new int[] {i++, k});
        	}
        }
        
        double[] partSize = makeSize(arr);
        
        int xEnd = arr.size()-1;
        int size = ranges.length;
        answer = new double[size];
        
        for (int r = 0; r < size; r++) {
			int start = ranges[r][0];
			int end = ranges[r][1];
			
			if(start > xEnd || xEnd + end < start) {
				answer[r] = -1.0;
				
			} else {
				double sum = 0;
				for (int j = start; j < xEnd + end; j++) {
					sum += partSize[j];
				}
				
				answer[r] = sum;
			}
		}
        
        return answer;
    }
	
	public static double[] makeSize(ArrayList<int[]> arr) {
		int size = arr.size() - 1;
		double[] result = new double[size];
		
		for (int i = 0; i < size; i++) {
			int min = Math.min(arr.get(i)[1], arr.get(i+1)[1]);
			int max = Math.max(arr.get(i)[1], arr.get(i+1)[1]);
			
			result[i] = min + (max-min) / 2.0;
		}
		
		return result;
	}
}
