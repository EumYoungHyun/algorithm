package sooan;

import java.util.Arrays;

public class Solution_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
        	int a = commands[i][0];
        	int b = commands[i][1];
        	int k = commands[i][2];
        	int[] splited = new int[b-a+1];
        	int idx = 0;
        	for (int j = a-1; j < b; j++) {
				splited[idx++] = array[j];
			}
        	Arrays.sort(splited);
        	answer[i] = splited[k-1];
		}
        return answer;
    }
}
