package sungchan;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_프린터 {
	public static void main(String[] args) {
		int priorities[] = { 2, 1, 3, 2 };
		int location = 2;

		System.out.println(solution(priorities, location));
	}

	public static int solution(int[] priorities, int location) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int num[] = new int[10];

		for (int i = 0; i < priorities.length; i++) {
			int temp = priorities[i];
			num[temp]++;
			queue.add(i);
		}

		int order = 1;
		while (!queue.isEmpty()) {
			int temp = queue.poll();

			boolean check = true;
			for (int i = priorities[temp] + 1; i < num.length; i++) {
				if (num[i] > 0) {
					check = false;
					break;
				}
			}

			if (check) {
				if (temp == location) {
					return order;
				} else {
					num[priorities[temp]]--;
					order++;
				}
			} else {
				queue.add(temp);
			}
		}

		return -1;
	}
}
