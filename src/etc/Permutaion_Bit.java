package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Permutaion_Bit {
	// N개 중 R개의 순열 뽑기
	static int N, R;
	
	// arr - 입력받을 배열
	// temp - 순열을 저장할 배열
	static int[] arr, temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		temp = new int[R];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		bitPerm(0, 0);
	}
	
	// 비트마스킹 순열 만들기
	// arr의 요소를 하나씩 탐색하면서 temp에 순서대로 넣어본다.
	// 이미 선택된 요소는 선택하지 않는다. 
	private static void bitPerm(int cnt, int flag) {
		// 기저조건
		// 순열의 크기가 찾고자하는 R의 크기가 되었을 때 재귀를 종료
		if(cnt == R) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			// 이미 선택된 숫자일 경우 건너뛴다
			if((flag & 1<<i) != 0)
				continue;
			
			// cnt의 위치에 순서대로 arr의 값을 넣는다.
			temp[cnt] = arr[i];
			
			// 선택된 숫자를 표시하고 재귀를 태운다.
			bitPerm(cnt+1, flag | 1<<i);
		}
	}
}