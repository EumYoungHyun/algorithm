package sooan;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_프린터 {
	public static void main(String[] args) {
		Solution_프린터 s = new Solution_프린터();
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		int ans = s.solution(priorities, location);
		System.out.println(ans);
	}

	public int solution(int[] priorities, int location) {
		int answer = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < priorities.length; i++) {
			pq.offer(priorities[i]);
		}
		System.out.println(Arrays.toString(priorities));
		System.out.println(pq.toString());
next:	while(!pq.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if(priorities[i] == pq.peek()) {
					if(i == location) {
						break next;
					}
					pq.poll();
					answer++;
				}
			}
		}
		
		return answer;
	}
}
