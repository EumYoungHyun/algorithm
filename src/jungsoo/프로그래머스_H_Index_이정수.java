package 프로그래머스;

import java.util.Arrays;

public class 프로그래머스_H_Index_이정수 {
	 public int solution(int[] citations) {
	       int answer = 0;
	        Arrays.sort(citations);
	        int len=citations.length;

	        for(int i=len;i>=0;i--){
	            int h=i;//가장 큰 수 부터 뽑음

	            int point=0;
	            for(int j=0;j<len;j++){
	                if(citations[j]<h)
	                    point++;
	                else
	                    break;
	            }

	            int row=point;
	            int high=len-point;
	            if(h<=high && row<=h){
	                answer=h;
	                break;
	            }
	        }
	        return answer;
	    }
}
