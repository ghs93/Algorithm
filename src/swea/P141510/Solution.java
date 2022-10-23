package swea.P141510;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 14150. 나무 높이
 * @author hoseong
 * @category 그리디
 */
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			int max = 0; //가장 큰 나무의 높이
			int[] trees = new int[N];
			for (int i = 0; i < N; i++) {
				int t = Integer.parseInt(st.nextToken());
				trees[i] = t;
				
				max = Math.max(max, t);
			}
			
			//나무가 자라야 할 높이에서 필요한 1, 2의 개 수 구하기
			int even = 0, odd = 0;
			for (int i = 0; i < N; i++) {
				int diff = max - trees[i];
				
				if(diff == 0) continue;
				
				even += diff / 2;
				odd += diff % 2;
			}
			
			//2 -> 1로 변경
			if(even > odd) {
				while(Math.abs(even - odd) > 1) {
					even--;
					odd += 2;
				}
			}
			
			int result = 0;
			if(odd > even) { //1이 많을 경우
				result = odd * 2 - 1;
				
			} else if(even > odd) { //2가 많을 경우 
				result = even * 2;
				
			} else { //1과 2의 숫자가 같을 경우
				result = odd + even;
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}