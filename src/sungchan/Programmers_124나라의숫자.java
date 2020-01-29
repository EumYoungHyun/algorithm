package sungchan;

public class Programmers_124나라의숫자 {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}

	public static String solution(int n) {
		String result = "";

		while (true) {
			if (n <= 3) {
				if (n == 3) {
					result = "4" + result;
				} else {
					result = n + result;
				}
				break;
			}

			int temp = (n - 1) % 3;
			if (temp == 2) {
				result = "4" + result;
			} else {
				result = (temp + 1) + result;
			}

			n = (n - 1) / 3;
		}

		return result;
	}
}
