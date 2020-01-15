package sungchan;

public class Programmers_큰수만들기 {
	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
	}
	
	public static String solution(String number, int k) {
		int size[] = new int[number.length()];
        
        for(int i=0; i<number.length(); i++) {
            for(int j=i+1; j<number.length(); j++) {
                if(number.charAt(i) >= number.charAt(j)) {
                	size[i]++;
                } else {
                	break;
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<number.length(); i++) {
            if(size[i] >= k) {
                result.append(number.charAt(i));
            } else {
                k--;
            }
        }
        
        return result.toString();
    }
}
