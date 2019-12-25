package sooan;

import java.util.ArrayList;
import java.util.List;

public class Solution_기능개발 {

	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> list = new ArrayList<>();
		int pre = (100 - progresses[0]) / speeds[0] + 1;
		int cnt = 0;
		int now = 0;
		for (int i = 0; i < progresses.length; i++) {
			if ((100 - progresses[i]) % speeds[i] != 0) {
				now = (100 - progresses[i]) / speeds[i] + 1;
			} else {
				now = (100 - progresses[i]) / speeds[i];
			}
			System.out.print(now + " ");
			if (now <= pre) {
				cnt++;
			} else {
				list.add(cnt);
				cnt = 1;
				pre = now;
			}
			System.out.println(cnt);
		}
		list.add(cnt);
		System.out.println(list.toString());
//        list.stream().mapToInt(Integer::intValue).toArray();
//        list.stream().mapToInt(i->i).toArray();
		return list.stream().mapToInt(i -> i).toArray();
	}
}
