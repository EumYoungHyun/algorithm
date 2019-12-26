package jungsoo;

import java.util.LinkedList;
import java.util.Queue;
public class 프로그래머스_기능개발_이정수 {
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] answer = {};
		int idx = 0;
		int cnt = 0;
		while (true) {
			for (int i = idx; i < 100; i++) {
				if (progresses[idx] < 100) {
					for (int j = idx; j < progresses.length; j++) {
						progresses[j] += speeds[j];
					}
				} else {
					break;
				}
			}
			for (int j = idx; j < progresses.length; j++) {
				if (progresses[j] >= 100) {
					idx++;
					cnt++;
				} else {
					break;
				}
			}
			q.add(cnt);
			cnt = 0;
			if (idx == progresses.length)
				break;

		}
		answer = new int[q.size()];
		int index = 0;
		for (int k : q) {
			answer[index++] = k;
		}
		return answer;
	}
}