package jungsoo;

import java.util.*;

public class 프로그래머스_탑_이정수 {

	public static void main(String[] args) {
		프로그래머스_탑_이정수 s = new 프로그래머스_탑_이정수();
		int arr[] = { 6, 9, 5, 7, 4 };
		int arr1[] = {3,9,9,3,5,7,2  };
		int arr2[] = { 1,5,3,6,7,6,5 };
		System.out.println(Arrays.toString(s.solution(arr)));
		System.out.println(Arrays.toString(s.solution(arr1)));
		System.out.println(Arrays.toString(s.solution(arr2)));
		

	}

	public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
  
        for(int i=heights.length-1;i>0;i--){
        	for(int j=i-1;j>=0;j--){
        		if(heights[i]<heights[j]){
        			answer[i]=j+1;
        			break;
        		}
        	}
        }
        return answer;
    }

}
