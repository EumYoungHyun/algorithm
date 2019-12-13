package younghyun;

import java.util.Arrays;

public class programmers_H_Index {
	public static void main(String[] args) {
		int[] citations = {0, 1, 2, 3};
		System.out.println(solution(citations));
	}
	 public static int solution(int[] citations) {
	        int answer = 0;

	        Arrays.sort(citations);
	        int[] copy = new int[citations.length + 1];
	        int index = 1;
	        for(int i = citations.length - 1; i >= 0; i--) {
	            copy[index++] = citations[i];
	        }
	        for(int i = 1; i < copy.length; i++) {
	            answer = Math.max(answer, Math.min(i, copy[i]));
	        }

	        return answer;
	    }
}
