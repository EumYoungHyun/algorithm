package jongho;

import java.util.*;

public class Solution_prog_42583_다리를지나는트럭 {
	public static void main(String[] args) {
		int[] s = new int[] { 7,4,5,6 };
		System.out.println(solution(2, 10, s));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Integer> wait = new LinkedList<Integer>();
		List<Truck> working = new ArrayList<Truck>();
		for (int truck : truck_weights) {
			wait.add(truck);
		}
		int wei = wait.peek();

		working.add(new Truck(wait.poll(), 0));

		while (!working.isEmpty()) {
			answer++;
			for (int i = 0; i < working.size(); i++) {
				working.get(i).index++;
			}
			if (working.get(0).index > bridge_length) {
				wei -= working.get(0).weight;
				working.remove(0);
			}
			if (!wait.isEmpty() && wei + wait.peek() <= weight) {
				int nextTruck = wait.poll();
				wei += nextTruck;
				working.add(new Truck(nextTruck, 1));
			}
		}
		return answer;
	}

	public static class Truck {
		int weight = 0;
		int index = 0;

		public Truck(int weight, int index) {
			this.weight = weight;
			this.index = index;
		}
	}
}
