package swea.P4008;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA 4008. 숫자 만들기 
 * @author hoseong
 * @category 순열, 백트래킹
 */
public class Solution {
	static int N, op[], nums[], opt[], max, min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			N = Integer.parseInt(br.readLine());
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			op = new int[4];
			opt = new int[N-1];
			nums = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			perm(0);
			System.out.println("#" + tc + " " + (max - min));
		}
	}
	
	static void perm(int cnt) {
		if(cnt == N-1) {
			calc();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(op[i] == 0) continue;
			
			op[i]--;
			opt[cnt] = i;
			perm(cnt+1);
			op[i]++;
		}
	}
	
	static void calc() {
		int result = nums[0];
		
		for (int i = 1; i < N; i++) {
			switch (opt[i-1]) {
			case 0:
				result += nums[i];
				break;
				
			case 1:
				result -= nums[i];
				break;
				
			case 2:
				result *= nums[i];
				break;
				
			case 3:
				result /= nums[i];
				break;
			}
		}
		
		max = Math.max(max, result);
		min = Math.min(min, result);
	}
}