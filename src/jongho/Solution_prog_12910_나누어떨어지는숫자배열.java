package jongho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// calc
public class Solution_prog_12910_나누어떨어지는숫자배열 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {5,9,7,10},5)));
	}
	public static int[] answer;
	public static int[] solution(int[] arr, int divisor) {
		int[] arrs = new int[arr.length];
		Arrays.sort(arr);
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				arrs[cnt++] = arr[i];
			}
		}
		if (cnt == 0) {
			answer = new int[] { -1 };
		} else {
			answer = new int[cnt];
			for (int i = 0; i < cnt; i++) {
				answer[i] = arrs[i];
			}
		}
		return answer;
	}
}