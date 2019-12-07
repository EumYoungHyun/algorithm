package younghyun;

import java.util.Arrays;

public class programmers_탑 {
	public static void main(String[] args) {
		int[] heights = {3,9,9,3,5,7,2};
		Solution(heights);
	}
	public static void Solution(int[] heights) {
		System.out.println(Arrays.toString(heights));
		int [] answer = new int[heights.length];
		
		for (int i = 1; i < answer.length; i++) {
			int idx = i;
			while(--idx>=0) {
				if(heights[idx] > heights[i]) {
					answer[i] = idx+1;
					break;
				}
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}
}
