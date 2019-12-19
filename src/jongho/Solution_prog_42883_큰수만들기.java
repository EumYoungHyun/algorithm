package jongho;
import java.util.*;

//Greedy
public class Solution_prog_42883_큰수만들기 {
	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;
		System.out.println(solution(number, k));
	}
    public static String solution(String number, int k) {
        String answer = "";
        int n = number.length()-k, i=0, ind=0, tempk=k;
  ret:      while(answer.length()!=n){
            int max=0;
            for(; i<tempk+1; i++){
                if(number.charAt(i)-'0'>max){
                    if(k+answer.length()==i){
                        answer+=(number.substring(i,number.length()));
                        break ret;
                    }
                    max=number.charAt(i)-'0';
                    ind=i;
                }
            }
            tempk++;
            if(tempk+1>number.length()) tempk=number.length()-1;
            answer+=max;
            i=ind+1;
        }
        return answer;
    }
}