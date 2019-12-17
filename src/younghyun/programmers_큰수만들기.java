package younghyun;

public class programmers_큰수만들기 {
	public static void main(String[] args) {
		programmers_큰수만들기 s = new programmers_큰수만들기();
		System.out.println(s.solution("44547444", 4));
	}
	public String solution(String number, int k) {
        String answer = "";
        int s = 0;
        int max = number.charAt(0)-'0';
        int end = k;
        for (int i = 0; i < number.length()-k; i++) { // 전체길이
			for (int j = s+1; j <= end; j++) {
				if(max < number.charAt(j)-'0') {
					max = number.charAt(j)-'0';
					s = j;
				}
			}
			answer+= max;
			max = 0;
			end++;
		}
        
        return answer;
    }
}
