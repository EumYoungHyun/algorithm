package younghyun;

public class programmers_124나라의숫자 {
	public static void main(String[] args) {
		programmers_124나라의숫자 s = new programmers_124나라의숫자();
		System.out.println(s.solution(4));
	}

	public String solution(int n) {
		String answer = "";
		while (n != 0) {
			int x = n % 3;
			n /= 3;
			if (x == 0) {
				answer += 4;
				n--;
			} else
				answer += x;
		}
		String temp = answer;
		answer = "";
		for (int i = temp.length() - 1; i >= 0; i--) {
			answer += temp.charAt(i);
		}
		return answer;
	}
}
