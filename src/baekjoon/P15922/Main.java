package baekjoon.P15922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 15922. 아우으 우아으이야!! - 골드 5
 * @author hoseong
 * @category 스위핑
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
		
		//이미 정렬된 상태로 입력이 들어오기 때문에 따로 정렬할 필요 없음
		int result = 0;
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if(s <= to) { //새로 들어온 입력의 출발점이 기존 범위의 끝점보다 작을 경우 끝점 비교 후 갱신
				to = Math.max(e, to);
				
			} else { //새로 들어온 입력의 출발점이 기존 범위의 끝점보다 클 경우 기존 범위 구간을 누적하고 범위를 새로 갱신
				result += Math.abs(to - from);
				from = s;
				to = e;
			}
		}
		
		//지금까지 구한 구간의 범위 누적
		result += Math.abs(to - from);
		System.out.println(result);
	}
}