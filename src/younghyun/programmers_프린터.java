package younghyun;

import java.util.LinkedList;
import java.util.Queue;

public class programmers_프린터 {
	public static void main(String[] args) {

		int[] priorities = {1, 1, 9, 1, 1, 1};

		System.out.println(solution(priorities, 3));

	}

	public static int solution(int[] priorities, int location) {
		class Print{
			public int index;
			public int priority;

			public Print(int index, int priority) {
				this.index = index;
				this.priority = priority;
			}

			@Override
			public String toString() {
				return "index=" + index + ", priority=" + priority;
			}
			
		}
		
		/**
		 * 우선순위 높은 수의 개수를 파악 비교대상 전체를 검색하지 않고 큐의 뒤로 보낼지 프린트할지 파악 가능
		 */
		int[] priorityCount = new int[10];
		Queue<Print> printList = new LinkedList<>();
		
		for (int i = 0; i < priorities.length; i++) {
			priorityCount[priorities[i]]++;
			printList.add(new Print(i, priorities[i]));
		}
		
		// 프린트 순서를 저장할 배열
		int[] printOrder = new int[priorities.length];
		int max = 0;
		int count = 0;
		
		// 출력순서 저장변수
		int num = -1;
		//Queue가 모두 소진될때까지 반복
		while(!printList.isEmpty()) {
			//최고 우선순위를 다 출력했을 경우
			if (count == 0) {
				max = 0;
				for (int j = 9; j >= 1; j--) {
					if (max < j && priorityCount[j] != 0) {
						max = j;
						count = priorityCount[j];
						break;
					}
				}
			}
			Print print = printList.poll();
			if(max == print.priority) {
				printOrder[print.index] = ++num;
				count--;
				priorityCount[print.priority]--;
			}else {	 //우선순위가 높은 문서가 존재할 경우 
				printList.add(print);
			}
		}
		
		return printOrder[location]+1;
	}
}
