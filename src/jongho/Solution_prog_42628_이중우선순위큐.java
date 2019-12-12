package jongho;

import java.util.*;

public class Solution_prog_42628_이중우선순위큐 {
	public int[] solution(String[] operations) {
		int[] answer = { 0, 0 };
		PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> pqMin = new PriorityQueue<>();

		for (String op : operations) {
			String[] str = op.split(" ");

			if (str[0].equals("I")) {
				pqMax.add(Integer.parseInt(str[1]));
				pqMin.add(Integer.parseInt(str[1]));
			}

			if (str[0].equals("D")) {
				if (!pqMax.isEmpty()) {
					if (str[1].equals("1")) {
						int max = pqMax.peek();
						pqMax.remove(max);
						pqMin.remove(max);

					} else {
						int min = pqMin.peek();
						pqMax.remove(min);
						pqMin.remove(min);
					}
				}
			}
		}
		if (!pqMax.isEmpty()) {
			answer[0] = pqMax.peek();
			answer[1] = pqMin.peek();

		}
		return answer;
	}
}
