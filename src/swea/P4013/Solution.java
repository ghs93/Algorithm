package swea.P4013;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA 4013. 특이한 자석 
 * @author hoseong
 * @category 구현
 */
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			int K = Integer.parseInt(br.readLine());
			ArrayList<Integer>[] mag = new ArrayList[5];
			ArrayList<int[]> rotate = new ArrayList<>();
			
			for (int i = 0; i < 5; i++) {
				mag[i] = new ArrayList<>();
			}
			
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					mag[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				rotate.add(new int[] {m, d});
			}
			
			int sum = 0;
			
			int[] isRotate = new int[5];
			while(!rotate.isEmpty()) {
				int[] target = rotate.remove(0);
				
				Arrays.fill(isRotate, 0);
				isRotate[target[0]] = target[1];
				
				//target보다 앞
				for (int i = target[0]-1; i > 0; i--) {
					//서로 다른 극
					if(isRotate[i+1] != 0 && mag[i].get(2) + mag[i+1].get(6) == 1) {
						isRotate[i] = isRotate[i+1] * -1;
					}
				}
				
				//target보다 뒤
				for (int i = target[0]+1; i < 5; i++) {
					//서로 다른 극
					if(isRotate[i-1] != 0 && mag[i].get(6) + mag[i-1].get(2) == 1) {
						isRotate[i] = isRotate[i-1] * -1;
					}
				}
				
				//회전
				for (int i = 1; i < 5; i++) {
					if(isRotate[i] == -1) {
						int temp = mag[i].remove(0);
						mag[i].add(temp);
						
					} else if(isRotate[i] == 1) {
						int temp = mag[i].remove(7);
						mag[i].add(0, temp);
					}
				}
			}
			
			for (int i = 1; i < 5; i++) {
				sum += mag[i].get(0) * Math.pow(2, i-1);
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}
}