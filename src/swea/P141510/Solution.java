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
			
			int max = 0;
			int[] trees = new int[N];
			for (int i = 0; i < N; i++) {
				int t = Integer.parseInt(st.nextToken());
				trees[i] = t;
				
				max = Math.max(max, t);
			}
			
			int even = 0, odd = 0, cnt = 0;
			for (int i = 0; i < N; i++) {
				int diff = max - trees[i];
				
				if(diff == 0) continue;
				
				even += diff / 3;
				odd += diff / 3;
				
				if(diff % 3 == 2) {
					even++;
					
				} else if(diff % 3 == 1) {
					odd++;
				}
			}
			
			int sum = 0;
			while(true) {
				if(odd > even) {
					if(even == 0) {
						sum = odd * 2 - 1;
						break;
						
					} else if(odd - even == 1) {
						sum = odd + even;
						break;
						
					} else {
						sum = (even * 2) + (odd - even)/2 + (odd - even)%2;
						break;
					}
					
				} else if(odd == even) {
					sum = odd + even;
					break;
					
				} else {
					if(odd == 0 || even - odd == 1) {
						sum = even * 2;
						break;
					
					} else {
						even--;
						odd += 2;
					}
				}
			}
			
			System.out.println("#" + tc + " " + sum);
		}

	}
}