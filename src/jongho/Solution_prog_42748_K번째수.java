package jongho;

import java.util.*;

public class Solution_prog_42748_K번째수 {
	   public int[] solution(int[] array, int[][] commands) {
	        int[] temp;
	        int[] answer=new int[commands.length];
	        for(int i=0; i<commands.length; i++){
	            temp=new int[commands[i][1]-commands[i][0]+1];
	            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
	                temp[j-commands[i][0]+1]=array[j];
	            }
	            Arrays.sort(temp);
	            answer[i]=temp[commands[i][2]-1];
	        }
	        return answer;
	    }
}
