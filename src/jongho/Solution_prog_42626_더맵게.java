package jongho;

import java.util.*;

public class Solution_prog_42626_더맵게 {
	public static void main(String[] args) {
		int[] s2 = new int[] { 1, 2, 3, 9, 10, 12 };
		System.out.println(solution(s2, 7));
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}
		pq.
		System.out.println(pq);
		while (pq.peek() < K) {
			if (pq.size() == 1)
				return -1;
			pq.add(pq.poll() + pq.poll() * 2);
			answer++;
		}

		return answer;
	}
}
