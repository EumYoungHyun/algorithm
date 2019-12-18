package younghyun;

import java.util.Arrays;
class programmers_체육복{
    public int solution(int n, int[] lost, int[] reserve) {
        int lidx = 0;
        int ridx = 0;
        int answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        while(ridx < reserve.length && lidx < lost.length){
            if(reserve[ridx]< lost[lidx]){
                if(ridx+1<reserve.length && reserve[ridx+1] == lost[lidx]){
                    ridx+=2;
                    lidx++;
                    answer++;
                }else if(reserve[ridx]+1 == lost[lidx]){
                    answer++;
                    ridx++;
                    lidx++;
                }else
                ridx++;
            }else if(reserve[ridx]>lost[lidx]){
                if(lidx+1<lost.length && reserve[ridx] == lost[lidx+1]){
                    lidx+=2;
                    ridx++;
                    answer++;
                }else if(reserve[ridx] == lost[lidx]+1){
                    answer++;
                    ridx++;
                    lidx++;
                }else
                lidx++;
            }else {
                answer++;
                ridx++;
                lidx++;
            }
                
            
        }
        
        
        return answer;
    }
}