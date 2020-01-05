package jongho;

// String
public class Solution_prog_12916_문자열내p와y의개수 {
	public static void main(String[] args) {
		System.out.println(solution("pPoooyY"));
	}
	static boolean solution(String s) {
        boolean answer = true;

        s=s.toLowerCase();
        int pCnt=0, yCnt=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='p') pCnt++;
            else if(s.charAt(i)=='y') yCnt++;
        }
        if(pCnt!=yCnt) answer=false;
        System.out.println(pCnt+" "+yCnt);
        return answer;
    }
}