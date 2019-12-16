package sooan;

public class Solution_큰수만들기 {
    public String solution(String number, int k) {
    	StringBuilder sb = new StringBuilder();
        int idx = 0;
        int max = number.charAt(idx)-'0';
        int len = number.length()-k;
        
        for(int i=0; i<number.length()-k; i++){	//구해야 하는 답의 자리수만큼 돌기
            for(int j=idx+1; j<=number.length()-len; j++){ //전체 길이-남은 답의 길이 전까지만 바라보기
                if(number.charAt(j)-'0' > max){
                    max = number.charAt(j)-'0';
                    idx = j;
                }
            }
            sb.append(max);
            max = 0;
            len--; //한자리를 구한 것이므로 답의 길이 줄여줌
        }
        return sb.toString();
    }
}
