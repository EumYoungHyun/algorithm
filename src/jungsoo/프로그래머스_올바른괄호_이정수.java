package jungsoo;

import java.util.Stack;
public class 프로그래머스_올바른괄호_이정수 {
	boolean solution(String s) {
		boolean answer = true;
		Stack<Character> st = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(') {
				st.push(c);
			} else { // c=')'인경우
				if (st.isEmpty())
					return false;
				else {
					if (st.peek() == '(')
						st.pop();
					else
						return false;
				}
			}
		}
		if (st.size() != 0)
			return false;
		return answer;
	}
}