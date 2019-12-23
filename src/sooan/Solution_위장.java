package sooan;

import java.util.HashMap;
import java.util.Map;

public class Solution_위장 {
	public static void main(String[] args) {
		Solution_위장 s = new Solution_위장();
		String[][] clothes = {{"a","face"},{"b","face"}, {"c","eye"}};
		System.out.println(s.solution(clothes));
	}
	public int solution(String[][] clothes) {
		int answer = 1;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < clothes.length; i++) {
			if(map.get(clothes[i][1])!=null) {
				map.put(clothes[i][1], map.get(clothes[i][1])+1);
			}else {
				map.put(clothes[i][1], 1);
			}
		}
		for(int m : map.values()) {
			answer *= (m+1);
		}
		return answer-1;
	}
}
