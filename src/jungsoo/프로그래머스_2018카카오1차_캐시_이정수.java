package jungsoo;
import java.util.*;

public class 프로그래머스_2018카카오1차_캐시_이정수 {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		ArrayList<String> list = new ArrayList<>();
		HashSet<String> set = new HashSet<>();
		if (cacheSize == 0)
			return 5 * cities.length;
		for (int i = 0; i < cities.length; i++) {
			String s = cities[i].toLowerCase();
			if (list.size() >= cacheSize) {
				if (!set.contains(s)) {
					answer += 5;
					set.remove(list.get(0));
					list.remove(0);
					list.add(s);
					set.add(s);
				} else {
					answer += 1;
					list.remove(s);
					list.add(s);
				}
			} else {
				if (!set.contains(s)) {
					answer += 5;
					list.add(s);
					set.add(s);
				} else {
					answer += 1;
					list.remove(s);
					list.add(s);
				}
			}
		}
		return answer;
	}
}