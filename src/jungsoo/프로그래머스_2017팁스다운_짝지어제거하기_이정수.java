package jungsoo;

import java.util.*;

public class 프로그래머스_2017팁스다운_짝지어제거하기_이정수 {

	public static void main(String[] args) {
		프로그래머스_2017팁스다운_짝지어제거하기_이정수 s = new 프로그래머스_2017팁스다운_짝지어제거하기_이정수();
		System.out.println(s.solution("baabaa"));
		System.out.println(s.solution("cdcd"));
	}

	public int solution(String s) {
		if (s.length() % 2 == 1)
			return 0;
		Stack<Character> st=new Stack<>();
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(st.isEmpty() || st.peek() !=c){
				st.push(c);
			} else{
				st.pop();
			}
		}
		if(st.isEmpty())
			return 1;
		return 0;
	}
}
