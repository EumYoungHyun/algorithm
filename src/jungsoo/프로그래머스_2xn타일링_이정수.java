package jungsoo;

public class 프로그래머스_2xn타일링_이정수 {
	public int solution(int n) {
		int answer = 0;
		int first = 1;
		int second = 2;
		for (int i = 0; i < n - 2; i++) {
			answer = first + second;
			first = second % 1000000007;
			second = answer % 1000000007;
		}
		return answer % 1000000007;
	}
}