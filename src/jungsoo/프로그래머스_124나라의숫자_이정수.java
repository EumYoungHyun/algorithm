package jungsoo;

public class 프로그래머스_124나라의숫자_이정수 {
	
	public String solution(int n) {
		String answer = "";
		while (n > 0) {
			int mod = n % 3;
			n /= 3;
			if (mod == 0) {
				mod = 4;
				n -= 1;
			}
			answer = mod + answer;
		}
		return answer;
	}
}