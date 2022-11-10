package programmers.P133499;

import java.util.HashMap;

/**
 * Programmers 133499. 옹알이2 
 * @author hoseong 
 * @category 문자열
 */
public class Solution {

	public static void main(String[] args) {
		int result = solution(new String[] {"aya", "yee", "u", "maa"});
//		int result = solution(new String[] { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" });

		System.out.println(result);
	}

	public static int solution(String[] babbling) {
		int answer = 0;

		HashMap<Character, String> map = new HashMap<>();
		map.put('a', "aya");
		map.put('y', "ye");
		map.put('w', "woo");
		map.put('m', "ma");

		loop: for (int i = 0, size = babbling.length; i < size; i++) {
			String bab = babbling[i];

			char block = '\t';
			for (int j = 0, bSize = bab.length(); j < bSize; j++) {
				if (bab.charAt(j) != block && (bab.charAt(j) == 'a' || bab.charAt(j) == 'y' || bab.charAt(j) == 'w' || bab.charAt(j) == 'm')) {
					String value = map.get(bab.charAt(j));

					int end = j+value.length();
					if (end < bSize+1 && bab.substring(j, end).equals(value)) {
						block = bab.charAt(j);
						j += value.length() - 1;

					} else {
						continue loop;
					}

				} else {
					continue loop;
				}
			}

			answer++;
		}

		return answer;
	}
}
