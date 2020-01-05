package jongho;

import java.util.Arrays;

// String
public class Solution_prog_12918_문자열다루기기본 {
	public static void main(String[] args) {
		System.out.println(solution("a234"));
	}
	public static boolean solution(String s) {
	      boolean answer = true;
	      if(s.length()!=4 && s.length()!=6) {return false;}
	      for(int i=0; i<s.length(); i++){
	          int n=s.charAt(i)-'0';
	          if(n<0 || n>=10) {answer=false; break;}
	      }
	      return answer;
	}
}