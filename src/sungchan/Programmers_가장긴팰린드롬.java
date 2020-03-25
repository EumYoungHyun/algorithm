package sungchan;

public class Programmers_가장긴팰린드롬 {
	public static void main(String[] args) {
		System.out.println(solution("abcdcba"));
		System.out.println(solution("abacde"));
	}
	
	public static int solution(String s) {
        boolean ispossible[][] = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++) {
            ispossible[i][i] = true;
        }
        
        int result = 1;
        
        for(int l=1; l<s.length(); l++) {
            for(int i=0; i+l<s.length(); i++) {
                if(s.charAt(i) == s.charAt(i+l)) {
                    if(l == 1) {
                        ispossible[i][i+l] = true;
                        result = Math.max(result, l+1);
                    } else {
                        if(ispossible[i+1][i+l-1]) {
                            ispossible[i][i+l] = true;
                            result = Math.max(result, l+1);
                        }
                    }
                }
            }
        }
        
        return result;
    }
}
