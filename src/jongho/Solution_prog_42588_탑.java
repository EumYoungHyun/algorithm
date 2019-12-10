package jongho;

import java.util.*;

public class Solution_prog_42588_탑 {
	public static void main(String[] args) {
		int[] s2 = new int[] {3, 9, 9, 3, 5, 7, 2};
		System.out.println(Arrays.toString(solution(s2)));
	}

    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        for(int i=heights.length-1; i>0; i--) {
        	for(int j=i-1; j>=0; j--) {
        		if(heights[i]<heights[j]) {
        			answer[i]=j+1;
        			break;
        		}
        	}
        }
        return answer;
    }
}
