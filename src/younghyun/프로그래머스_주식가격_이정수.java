package ���α׷��ӽ�;

public class ���α׷��ӽ�_�ֽİ���_������ {
	
	 public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        
	        for(int i=0;i<prices.length;i++){
	            int cnt=0;
	            boolean flag=false;
	            for(int j=i+1;j<prices.length;j++){
	                if(prices[i]>prices[j]){//������ �������� ����
	                    cnt++;//�������� ���� ���� 1�ʰ� ������ �������������Ƿ� 1�� �߰�
	                    answer[i]=cnt;
	                    flag=true;
	                    break;
	                } else{//������ �ȶ������� �����Ǵ� ��
	                    cnt++;
	                }
	            }
	            if(!flag){//������ ��� �ȶ������� ���
	               answer[i]=cnt;
	            }
	        } 
	        return answer;
	    }

}
