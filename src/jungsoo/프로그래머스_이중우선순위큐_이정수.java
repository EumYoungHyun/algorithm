package 프로그래머스;
import java.util.*;

public class 프로그래머스_이중우선순위큐_이정수 {
	
	public int[] solution(String[] operations) {
		int[] answer;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < operations.length; i++) {
			String temp[] = operations[i].split(" ");
			String order = temp[0];
			int num = Integer.parseInt(temp[1]);

			if (order.equals("I")) {
				list.add(num);
			} else {// "D"
				if (list.size() == 0)
					continue;
				Collections.sort(list);
				if (num == 1)
					list.remove(list.size() - 1);
				else
					list.remove(0);
			}
		}

		Collections.sort(list);
		if (list.size() == 0) {
			answer = new int[2];
		} else {
			answer = new int[2];
			answer[0] = list.get(list.size() - 1);
			answer[1] = list.get(0);
		}
		return answer;
	}
}