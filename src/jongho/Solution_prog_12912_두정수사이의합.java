package jongho;

// calc
public class Solution_prog_12912_두정수사이의합 {
	public static void main(String[] args) {
		System.out.println(solution(3,5));
	}
	public static long solution(int a, int b) {
		long answer = 0;
		long abs = Math.abs(b - a);
		answer = (a + b) * ((abs + 1) / 2);
		if (abs % 2 == 0) {
			answer += ((a + b) / 2);
		}
		return answer;
	}
}