package ���α׷��ӽ�;

public class ���α׷��ӽ�_������_������ {

	public static void main(String[] args) {
		���α׷��ӽ�_������_������ a=new ���α׷��ӽ�_������_������();
		int st=4;
		int d[]={1,2,3,4};
		int s[]={10,40,30,20};
		int k=100;
		System.out.println(a.solution(st, d, s, k));

	}
	
	 public int solution(int stock, int[] dates, int[] supplies, int k) {
	        int answer = 0;
	        int day=0;//��¥ �ε���
	        for(int i=1;i<k;i++){//k-1������ �ϸ��
	            stock--;//�Ϸ� �а��� �Һ�
	            
	            if(day==dates.length)
	            	break;
	            if(i==dates[day]){//���޳�¥
	                
	                if(day==dates.length-1){//������ ���޳�¥�� ��� day+1�� �� �� �����Ƿ� ���� �ۼ�
	                    if(stock<k-dates[day]){
	                        stock+=supplies[day];
	                        answer++;//Ƚ�� �߰�
	                    }
	                } else{
	                    if(stock<dates[day+1]-dates[day]){
	                        stock+=supplies[day];
	                        answer++;//Ƚ�� �߰�
	                     }
	                }
	                
	                day++;//���޳�¥�� �Ǵ� �� ���� ���޳�¥�� �Ѿ
	            } else{//���޳�¥ �ƴϸ� �׳� �а��� �Һ�
	                continue;
	            }
	            
	        }
	        return answer;
	    }

}
