package jongho;
import java.util.*;

//Stack
public class Solution_prog_42585_쇠막대기 {
	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));
	}
    public static Stack<Character> st;
    public static int solution(String arrangement) {
        int answer = 0;
        st = new Stack<>();
    for(int i=0;i<arrangement.length();i++){
		if(arrangement.charAt(i)=='(') st.push(arrangement.charAt(i));
		else if(arrangement.charAt(i)==')'){
			if(arrangement.charAt(i-1)==')') {
				answer+=1;
				st.pop();
			}
			else if(arrangement.charAt(i-1)=='(') {
				st.pop();
				answer+=st.size();
			}
		}
	}
        return answer;
    }
}