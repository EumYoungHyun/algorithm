package ���α׷��ӽ�;

import java.util.Arrays;

public class ���α׷��ӽ�_H_Index_������ {
	 public int solution(int[] citations) {
	       int answer = 0;
	        Arrays.sort(citations);
	        int len=citations.length;

	        for(int i=len;i>=0;i--){
	            int h=i;//���� ū �� ���� ����

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
