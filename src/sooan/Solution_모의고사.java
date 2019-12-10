package sooan;

import java.util.Arrays;

public class Solution_모의고사 {
	public int[] solution(int[] answers) {
		int[] answer = {};
		int[] value = new int[3];
		int[] ans1 = { 1, 2, 3, 4, 5 };
		int[] ans2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] ans3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int idx1 = 0, idx2 = 0, idx3 = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == ans1[idx1++])
				value[0]++;
			if (answers[i] == ans2[idx2++])
				value[1]++;
			if (answers[i] == ans3[idx3++])
				value[2]++;
			if (idx1 == ans1.length)
				idx1 = 0;
			if (idx2 == ans2.length)
				idx2 = 0;
			if (idx3 == ans3.length)
				idx3 = 0;
		}
		int max = Integer.MIN_VALUE;
		int aIdx = 0;
		int cnt = 0;
		for (int i = 0; i < value.length; i++) {
			if (value[i] > max) {
				max = value[i];
			}
		}
		for (int i = 0; i < value.length; i++) {
			if (value[i] == max) {
				cnt++;
			}
		}
		if (cnt == 0)
			cnt = 3;
		answer = new int[cnt];
		for (int i = 0; i < value.length; i++) {
			if (value[i] == max) {
				answer[aIdx++] = i + 1;
			}
		}
		return answer;
	}
}
