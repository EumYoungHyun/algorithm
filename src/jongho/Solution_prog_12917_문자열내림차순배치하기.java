package jongho;

import java.util.Arrays;

// String
public class Solution_prog_12917_문자열내림차순배치하기 {
	public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));
	}
	  public static String solution(String s) {
	      String answer = "";
	      int[] ss = new int[s.length()];
	      for(int i=0; i<s.length(); i++){
	          ss[i]=s.charAt(i)*-1;
	      }
	      Arrays.sort(ss);
	      for(int i=0; i<ss.length; i++){
	          answer+=(char)(ss[i]*-1);
	      }
	      return answer;
	  }
}