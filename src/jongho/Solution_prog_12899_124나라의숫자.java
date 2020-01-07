package jongho;

import java.util.Arrays;

// String
public class Solution_prog_12899_124나라의숫자 {
	public static void main(String[] args) {
		System.out.println(solution(500000000));
	} 
	  public static String solution(int n) {
	      String answer = "";
	      int m;
	        while(n>0){
	            m = n%3;
	            n = n/3;
	            if(m == 0){
	                n -= 1;
	                m = 4;
	            }
	            answer = m + answer;
	        }
	      return answer;
	  }
}