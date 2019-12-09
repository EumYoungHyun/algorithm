package younghyun;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class programmers_라면공장 {
	public static void main(String[] args) {
		int[] dates = { 4, 10, 15, 17, 18, 19 };
		int[] supplies = { 20, 5, 10, 3, 2, 5 };

		System.out.println(solution(4, dates, supplies, 30));
	}

	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		Queue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});

		int index = 0;
		for (int i = 0; i < k; i++) {
			if (index < dates.length && i == dates[index])
				priorityQueue.add(supplies[index++]);

			if (stock == 0) {
				stock += priorityQueue.poll();
				answer++;
			}
			stock -= 1;
		}
		return answer;
	}

}
