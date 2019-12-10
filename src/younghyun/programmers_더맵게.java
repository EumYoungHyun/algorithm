package younghyun;

import java.util.PriorityQueue;

public class programmers_더맵게 {
	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int a = solution(scoville, 7);
		System.out.println(a);
	}

	public static int solution(int[] scoville, int K) {

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int j = 0; j < scoville.length; j++) {
			queue.add(scoville[j]);
		}
		boolean flag = false;
		int answer = 0;
		while (true) {
			answer++;
			if (queue.size() < 2)
				return -1;
			int a = queue.poll();
			int b = queue.poll();
			queue.add(a + (2 * b));
			if (queue.peek() >K) {
				flag = true;
				break;
			}
			if (flag)
				break;
		}
		return answer;
	}
}
