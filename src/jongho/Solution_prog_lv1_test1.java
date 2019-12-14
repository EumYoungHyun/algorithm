package jongho;

import java.util.*;

public class Solution_prog_lv1_test1 {
	public static void main(String[] args) {
		int s=5;
		System.out.println(solution(s));
	}

	public static String solution(int n) {
		String answer = "";
		for (int i = 0; i < n; i++) {
			if (i % 2 == 1) {
				answer += "박";
			} else {
				answer += "수";
			}
		}
		return answer;
	}
}
