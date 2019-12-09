package sooan;

import java.util.*;

public class Solution_탑 {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        int[] stack = new int[heights.length];
        int top = -1;
        stack[++top] = 0;
        for(int i=0; i<heights.length; i++) {
        	while(top != -1) {
        		int tmp =stack[top--];
        		if(heights[tmp] > heights[i]) {
        			answer[i] = tmp+1;
        			stack[++top] = tmp;
        			break;
        		}
        	}
        	stack[++top] = i;
        }
        return answer;
    }
}
