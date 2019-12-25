package jungsoo;

import java.util.Stack;
public class 프로그래머스_큰수만들기_이정수 {
	
	public String solution(String number, int k) {
		int len = number.length() - k;
		int cnt = k;
		Stack<Character> stack = new Stack<>();
		char arr[] = new char[len];

		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			while (!stack.isEmpty() && stack.peek() < c) {
				if (cnt == 0)
					break;
				stack.pop();
				cnt--;
			}
			stack.push(c);
		}
		for (int i = 0; i < len; i++) {
			arr[i] = stack.get(i);
		}
		return new String(arr);
	}
}