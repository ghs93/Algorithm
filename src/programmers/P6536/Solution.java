package programmers.P6536;

/**
 * Programmers 6536. 스킬 체크 테스트 Level.2
 * @author hoseong
 * @category 배열 돌리기
 */
public class Solution {
	static int[][] dir = {{1, 0}, {0, 1}, {-1, -1}};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(6);
	}

    
    public static int[] solution(int n) {
        int[] answer = new int[(n * (n+1)) / 2];
        
        int[][] map = new int[n][];
        for(int i=1; i<=n; i++) {
        	map[i-1] = new int[i];
        }
        
        int cnt = 1, r = -1, c = 0;
        for(int i=0; i<n; i++) {
        	int d = i % 3;
        	
            for(int j=n-i; j>0; j--) {
            	r += dir[d][0];
            	c += dir[d][1];
            	
            	map[r][c] = cnt++;
            }
        }
        
        int i=0;
        for (int[] mp : map) {
			for (int m : mp) {
				answer[i++] = m;
			}
		}
        
        return answer;
    }
}
