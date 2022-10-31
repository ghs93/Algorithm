package programmers.P133502;

import java.util.Stack;

/**
 * Programmers 133502. 햄버거 만들기
 * @author hoseong
 * @category 
 */
public class Solution {
	public static void main(String[] args) {
		int r = solution(new int[] {1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1});
		System.out.println(r);
	}

	public static int solution(int[] ingredient) {
		int answer = 0;
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0, size = ingredient.length; i < size; i++) {
			if(ingredient[i] == 1 && stack.size() >= 3) {
				int s = stack.size() - 1;
				if(stack.get(s) == 3 && stack.get(s-1) == 2 && stack.get(s-2) == 1) {
					answer++;
					stack.pop();
					stack.pop();
					stack.pop();
					
				} else {
					stack.add(ingredient[i]);
				}
				
			} else {
				stack.add(ingredient[i]);
			}
		}

		return answer;
	}
}
