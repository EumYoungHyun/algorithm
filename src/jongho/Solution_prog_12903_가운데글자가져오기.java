package jongho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// String
public class Solution_prog_12903_가운데글자가져오기 {
	public static void main(String[] args) {
		System.out.println(solution("abcde"));
	}
	  public static String solution(String s) {
	      String answer = "";
	      if(s.length()%2==0){
	         answer+=s.substring(s.length()/2-1,s.length()/2+1);
	      }else{
	          answer+=s.charAt(s.length()/2);
	      }
	      return answer;
	  }
}