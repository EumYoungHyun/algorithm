package jongho;

import java.util.Arrays;

// String
public class Solution_prog_12919_서울에서김서방찾기 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"Jane","Kim"}));
	}
	public static String solution(String[] seoul) {
	      String answer = "";
	      for(int i=0; i<seoul.length; i++){
	          if(seoul[i].equals("Kim")){
	              answer+=("김서방은 "+i+"에 있다");
	          }
	      }
	      return answer;
	  }
}