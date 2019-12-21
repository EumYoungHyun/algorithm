package jungsoo;

import java.util.Arrays;
public class 프로그래머스_K번째수_이정수 {
	 public int[] solution(int[] array, int[][] commands) {
	        int[] answer = new int[commands.length];
	    
	        for(int i=0;i<commands.length;i++) {
	        	int []tmp= new int[commands[i][1]-commands[i][0]+1];
	        	int a=0;
	        	for(int j=commands[i][0]-1;j<commands[i][1];j++) {
	        		tmp[a++]=array[j];
	        	}
	        	Arrays.sort(tmp);
	            answer[i]=tmp[commands[i][2]-1];
	        }
	      
	        return answer;
	    }
}