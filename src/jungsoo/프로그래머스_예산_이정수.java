package jungsoo;

import java.util.*;

public class 프로그래머스_예산_이정수 {
	public int solution(int[] budgets, int M) {
		int answer = 0;
		Arrays.sort(budgets);
		long sum = 0;

		for (int i : budgets)
			sum += i;

		if (sum < M) {
			answer = budgets[budgets.length - 1];
			return answer;
		}
		int low = 0;
		int high = M;
		int mid = 0;
		int premid = 0;
		while (true) {
			sum = 0;
			mid = (low + high) / 2; // 배정할 예산 설정
			// 더이상 상한가의 변화가 없으면 종료
			if (mid == premid) {
				answer = mid;
				break;
			}

			for (int i = 0; i < budgets.length; i++) {
				if (budgets[i] < mid)
					sum += budgets[i];
				else {
					sum += mid * (budgets.length - i);
					break;
				}
			}
			if (sum <= M)
				low = mid;
			else
				high = mid;

			premid = mid;
		}
		answer = mid;
		return answer;
	}
}