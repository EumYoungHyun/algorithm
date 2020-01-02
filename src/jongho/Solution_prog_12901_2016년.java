package jongho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// calc
public class Solution_prog_12901_2016년 {
	public static void main(String[] args) {
		System.out.println(solution(5, 24));
	}
	public static String solution(int a, int b) {
		String answer = "";
		String[] days = new String[] { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
		int[] monthDays = new int[] { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		int ans = -1;
		for (int i = 0; i < a - 1; i++) {
			ans += monthDays[i];
		}
		ans += b;
		ans %= 7;
		answer = days[ans];

		return answer;
	}
}