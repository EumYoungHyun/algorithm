package younghyun;

import java.util.Arrays;

public class programmers_K번째수 {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
		
		System.out.println(Arrays.toString(solution(array, commands)));
	}

	public static int[] solution(int[] array, int[][] commands) {
		
		int[] answer = new int[commands.length];
		
		for (int i = 0; i < answer.length; i++) {
			int start = commands[i][0];
			int end = commands[i][1];
			int find = commands[i][2] - 1;
			int[] temp = new int[end - start + 1];
			temp = Arrays.copyOfRange(array, start-1, end);
			Arrays.sort(temp);
			answer[i] = temp[find];
		}
		
		return answer;
	}
}
