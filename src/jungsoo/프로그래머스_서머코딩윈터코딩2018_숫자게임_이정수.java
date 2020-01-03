package jungsoo;

import java.util.Arrays;
public class 프로그래머스_서머코딩윈터코딩2018_숫자게임_이정수 {
	public int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		int index = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = index; j < B.length; j++) {
				if (A[i] < B[j]) {
					index = j + 1;
					answer++;
					break;
				}
			}
		}
		return answer;
	}
}