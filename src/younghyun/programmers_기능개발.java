package younghyun;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class programmers_기능개발 {
	public static void main(String[] args) {
		programmers_기능개발 s = new programmers_기능개발();
		System.out.println(Arrays.toString(s.solution(new int[] {98, 30, 86}, new int[] {1, 30, 5})));
		
	}
	public int[] solution(int[] progresses, int[] speeds) {

		int[] answer = new int[progresses.length];
		Queue<Integer> queue = new LinkedList<>();
        
		for (int i = 0; i < answer.length; i++) {
			int temp = 100 - progresses[i];
			
			temp = (temp%speeds[i] == 0) ? temp/speeds[i]: temp/speeds[i] +1;
			
			answer[i] = temp;
		}
		int cnt = 1;
		int temp = answer[0];
		for (int i = 1; i < answer.length; i++) {
			if(answer[i] <= temp) {
				cnt++;
			}else {
				queue.add(cnt);
				cnt = 1;
				temp = answer[i];
			} 
		}
		queue.add(cnt);
		
		int[] list = new int[queue.size()];
		for (int i = 0; i < list.length; i++) {
			list[i] = queue.poll();
		}
		return list;
    }
}
