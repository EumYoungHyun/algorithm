package jongho;

import java.util.*;

//Greedy
public class Solution_prog_1829_2017카카오코드예선_카카오프렌즈컬러링북 {
	public static void main(String[] args) {
		int[] weights = new int[] { 3, 1, 6, 2, 7, 30, 1 };
		System.out.println(Arrays.toString(solution(6,4,weights)));
	}

	public static int[][] visit;
	public static int numberOfArea, maxSizeOfOneArea;

	public static int[] solution(int m, int n, int[][] picture) {
		numberOfArea = 0;
		maxSizeOfOneArea = 0;
		visit = new int[m][n];

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
}