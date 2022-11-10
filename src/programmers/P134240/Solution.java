package programmers.P134240;

/**
 * Programmers 134240. 푸드 파이트 대회
 * @author hoseong
 * @category 문자열
 */
public class Solution {
	public static void main(String[] args) {
//		String result = solution(new int[] {1, 3, 4, 6});
		String result = solution(new int[] {1, 7, 1, 2});
		
		System.out.println(result);
	}

	public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1, size = food.length; i < size; i++) {
			int cnt = food[i] / 2;
			
			for (int j = 0; j < cnt; j++) {
				sb.append(i);
			}
		}
        
        StringBuilder answer = new StringBuilder();
        answer.append(sb.toString()).append(0).append(sb.reverse().toString());
        
        return answer.toString();
    }
}
