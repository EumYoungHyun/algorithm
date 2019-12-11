package younghyun;

import java.util.Arrays;

public class programmers_모의고사 {
	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2};

		System.out.println(Arrays.toString(solution(answers)));
	}
	public static int[] solution(int[] answers) {
		
		int[] stu1 = {1, 2, 3, 4, 5};
		int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int idx1= 0;
		int idx2= 0;
		int idx3= 0;
		
		int score1 = 0;
		int score2 = 0;
		int score3 = 0;
		
		for (int i = 0; i < answers.length; i++) {
			
			if(answers[i] == stu1[idx1++%5]) {
				score1++;
			}
			if(answers[i] == stu2[idx2++%8]) {
				score2++;
			}
			if(answers[i] == stu3[idx3++%10]) {
				score3++;
			}
			
		}
		int max = 0;
		if(max < score1) max = score1;
		if(max < score2) max = score2;
		if(max < score3) max = score3;
		
		if(max == score1 && max == score2 && max == score3) 
			return new int[] {1, 2, 3};
		if(max == score1 && max == score2) 
			return new int[] {1, 2};
		if(max == score1 && max == score3) 
			return new int[] {1, 3};
		if(max == score2 && max == score3) 
			return new int[] {2, 3};
		if(max == score1) 
			return new int[] {1};
		if(max == score2) 
			return new int[] {2};

		return new int[] {3};
    }
}
