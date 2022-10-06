package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Permutation {
	// N개 중 R개의 순열 뽑기
	static int N, R;
	
	// arr - 입력받을 배열
	// temp - 순열을 저장할 배열
	static int[] arr, temp;
	
	// 순열을 만들기 위해 arr의 요소가 선택됐는지 안됐는지 판단하는 배열
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		temp = new int[R];
		isSelected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0);
	}
	
	// 재귀로 순열 만들기
	// arr의 요소를 하나씩 탐색하면서 temp에 순서대로 넣어본다.
	// 이미 선택된 요소는 선택하지 않는다. 
	private static void perm(int cnt) {
		// 기저조건
		// 순열의 크기가 찾고자하는 R의 크기가 되었을 때 재귀를 종료
		if(cnt == R) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		
		for (int i = 0; i < N; i++) {
			// 이미 선택된 숫자일 경우 건너뛴다
			if(isSelected[i])
				continue;
			
			// cnt의 위치에 순서대로 arr의 값을 넣는다.
			temp[cnt] = arr[i];
			
			// 선택된 숫자를 표시하고 재귀를 태운다.
			isSelected[i] = true;
			perm(cnt+1);
			
			// 해당 숫자의 사용을 해제한다.
			isSelected[i] = false;
		}
	}
}