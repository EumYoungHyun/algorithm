package jongho;
import java.util.*;

public class Solution_prog_42862_체육복 {
	public static void main(String[] args) {
		int[] lost = new int[] {2,4};
		int[] reserve = new int[] {1,3,5};
		System.out.println(solution(5,lost, reserve));
	}
	   public static int solution(int n, int[] lost, int[] reserve) {
	        int answer = 0;
	        int[] clothes = new int[n];
	        Arrays.fill(clothes, 1);
	        for(int i=0; i<lost.length; i++){
	            clothes[lost[i]-1]--;
	        }
	        for(int i=0; i<reserve.length; i++){
	            clothes[reserve[i]-1]++;
	        }
	        for(int i=0; i<n; i++){
	            if(clothes[i]==0){
	                if(i==0){
	                    if(clothes[i+1]==2) {clothes[i]++; clothes[i+1]--;}
	                }else if(i==n-1){
	                    if(clothes[i-1]==2) {clothes[i]++; clothes[i-1]--;}
	                }else{
	                    if(clothes[i-1]==2) {clothes[i]++; clothes[i-1]--; continue;}
	                    else if(clothes[i+1]==2) {clothes[i]++; clothes[i+1]--;}
	                }
	            }
	        }
	        for(int i=0; i<n; i++){
	            if(clothes[i]>0) answer++;
	        }
	        return answer;
	    }
}