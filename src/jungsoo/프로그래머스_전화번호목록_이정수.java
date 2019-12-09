package jungsoo;

import java.util.Arrays;

public class  프로그래머스_전화번호목록_이정수 {

	public static void main(String[] args) {
		프로그래머스_전화번호목록_이정수 a = new 프로그래머스_전화번호목록_이정수();
		String s[]={"119","97674223","1195524421"};
		System.out.println(a.solution(s));

	}

	 public boolean solution(String[] phone_book) {
	        boolean answer = true;
	        Arrays.sort(phone_book);
	        
	       outer: for(int i=0;i<phone_book.length;i++){
	            int len=phone_book[i].length();
	            for(int j=i+1;j<phone_book.length;j++){
	                if(len>phone_book[j].length())
	                    continue;
	                
	                String str=phone_book[j].substring(0,len);
	                if(str.equals(phone_book[i])){
	                    answer=false;
	                    break outer;
	                }
	            }
	        }
	        return answer;
	    }

}
