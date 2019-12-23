package younghyun;

class programmers_쇠막대기{
	public static void main(String[] args) {
		programmers_쇠막대기 s = new programmers_쇠막대기();
		System.out.println(s.solution("()(((()())(())()))(())"));
	}
	public int solution(String arrangement) {
		int answer = 1;
		int stack = 0;
		for (int i = 0; i < arrangement.length() - 1; i++) {
			if (arrangement.charAt(i) == '(') {

				if (arrangement.charAt(i + 1) == '(') {
					stack++;
				} else {
					i++;
					answer += stack;
				}
			} else {
				stack--;
				answer++;
			}
		}
		return answer;
	}
}
