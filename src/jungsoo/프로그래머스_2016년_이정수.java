package jungsoo;

public class 프로그래머스_2016년_이정수 {
	public String solution(int a, int b) {
		String answer = "";
		String[] day = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
		int temp = 0;
		if (a == 1) {
			answer = day[b % 7];
		} else {
			for (int i = 1; i < a; i++) {
				temp += getDay(i);
			}
			answer = day[(b + temp) % 7];
		}

		return answer;
	}

	public int getDay(int a) {
		if (a == 1 || a == 3 || a == 5 || a == 7 || a == 8 || a == 10 || a == 12)
			return 31;
		else if (a == 2)
			return 29;
		else
			return 30;
	}
}