package sooan;

import java.util.Arrays;

public class Solution_정수삼각형 {
	public static void main(String[] args) {
		Solution_정수삼각형 s = new Solution_정수삼각형();
		int[][] triangle = {
				{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}
		};
		System.out.println(s.solution(triangle));
		
	}
	public int solution(int[][] triangle) {
        int answer = -1;
        int[][] memo = new int[triangle.length][triangle.length];
        memo[0][0] = triangle[0][0]; //초기값
        for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if(j==0)
					memo[i][j] = memo[i-1][j] + triangle[i][j];
				else if(j==triangle[i].length-1)
					memo[i][j] = memo[i-1][j-1] + triangle[i][j];
				else {
					memo[i][j] = Math.max(memo[i-1][j-1], memo[i-1][j])
            				+ triangle[i][j];
				}
			}
		}
        for (int i = 0; i < triangle.length; i++) {
			System.out.println(Arrays.toString(memo[i]));
		}
        int len = triangle.length-1;
        for(int i=0; i<triangle[len].length; i++){
            if(answer < memo[len][i]){
                answer = memo[len][i];
            }
        }
        return answer;
    }
    
}
