package sooan;

public class Solution_쇠막대기 {
	public int solution(String arrangement) {
		int answer = 0;
		int s = 0;
		for (int i = 0; i < arrangement.length(); i++) {
			if (arrangement.charAt(i) == '(' && arrangement.charAt(i + 1) == ')') {
				answer += s;
				i++;
			} else if (arrangement.charAt(i) == '(') {
				s++;
			} else if (arrangement.charAt(i) == ')') {
				s--;
				answer++;
			}
		}
		return answer;
	}
}
