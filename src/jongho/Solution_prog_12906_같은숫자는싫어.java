package jongho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// String
public class Solution_prog_12906_같은숫자는싫어 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[]{1,1,3,3,0,1,1})));
	}
	public static int[] solution(int []arr) {
        int[] ans=new int[arr.length];
        int temp=arr[0];
        int cnt=0;
        ans[cnt++]=temp;
        for(int i=1; i<arr.length; i++){
            if(temp==arr[i]){
                continue;
            }else{
                ans[cnt++]=arr[i];
                temp=arr[i];
            }
        }
        int[] answer=new int[cnt];
        for(int i=0; i<answer.length; i++){
            answer[i]=ans[i];
        }
        
        return answer;
	}
}