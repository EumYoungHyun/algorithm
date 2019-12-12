package younghyun;

import java.util.Arrays;

public class programmers_SC_Level2_01 {
	public static void main(String[] args) {
		int[][] arr1= {{2, 3, 2},{4, 2, 4},{3, 1, 4}};
		int[][] arr2= {{5, 4, 3},{2, 4, 1}, {3, 1, 1}};
		int[][] arr = solution(arr1, arr2);
		for (int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
	}
	public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				int sum = 0;
				for (int k = 0; k < arr1[i].length; k++) {
					sum += arr1[i][k] * arr2[k][j];
				}
				answer[i][j] = sum;
			}
		}
		
        return answer;
    }
}
