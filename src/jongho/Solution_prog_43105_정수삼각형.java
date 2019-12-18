package jongho;
import java.util.*;

//Greedy
public class Solution_prog_43105_정수삼각형 {
	public static void main(String[] args) {
		int[][] triangle = new int[][] {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		System.out.println(solution(triangle));
	}
    public static int solution(int[][] triangle) {
        int answer = 0;
        for(int i=triangle.length-2; i>=0; i--){    // 부모, 위로
            for(int j=0; j<triangle[i].length; j++){   // 자식, 오른쪽으로
                triangle[i][j]+=Math.max(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }
        answer=triangle[0][0];
        return answer;
    }
}