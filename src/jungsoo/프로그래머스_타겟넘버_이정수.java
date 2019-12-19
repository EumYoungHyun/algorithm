package jungsoo;

public class 프로그래머스_타겟넘버_이정수 {
	int answer = 0;

	public int solution(int[] numbers, int target) {
		dfs(numbers, target, 0);
		return answer;
	}

	public void dfs(int[] numbers, int target, int depth) {
		if (depth == numbers.length) {
			int sum = 0;
			for (int i = 0; i < numbers.length; i++)
				sum += numbers[i];
			if (sum == target)
				answer++;
		} else {
			numbers[depth] *= 1;
			dfs(numbers, target, depth + 1);

			numbers[depth] *= -1;
			dfs(numbers, target, depth + 1);
		}
	}
}