package ���α׷��ӽ�;

import java.util.*;

public class ���α׷��ӽ�_ž_������ {

	public static void main(String[] args) {
		���α׷��ӽ�_ž_������ s = new ���α׷��ӽ�_ž_������();
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
