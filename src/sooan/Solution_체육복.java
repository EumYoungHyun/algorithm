package sooan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
    	int answer = n - lost.length;
        int lidx = 0;
        int ridx = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        while(lidx < lost.length && ridx < reserve.length){
            if(lost[lidx] == reserve[ridx]) { //값이 같은 경우
            	answer++;
                lidx++; ridx++;
                continue;
            }
            if(lost[lidx] == reserve[ridx]-1) { //앞번호일경우
            	//중복 방지를 위해 그 다음 값이 같은 값인지 확인해주기
            	if(lidx+1 < lost.length && lost[lidx+1] == reserve[ridx]) { 
            		lidx++;
            		continue;
            	}
            	answer++;
                lidx++; ridx++;
            }
            else if(lost[lidx] == reserve[ridx]+1){ //뒷번호일경우
            	if(ridx+1 < reserve.length && reserve[ridx+1] == lost[lidx]) {
            		ridx++;
            		continue;
            	}
                answer++;
                lidx++; ridx++;
            }else{
                if(lost[lidx] > reserve[ridx]){ //둘 중 작은 값의 인덱스를 증가
                    ridx++;
                }else{
                    lidx++;
                }
            }
        }
        return answer;
    }
}
