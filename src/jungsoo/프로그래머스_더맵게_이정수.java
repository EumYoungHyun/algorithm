package ���α׷��ӽ�;

import java.util.PriorityQueue;

public class ���α׷��ӽ�_���ʰ�_������ {

	public static void main(String[] args) {
		���α׷��ӽ�_���ʰ�_������ a=new ���α׷��ӽ�_���ʰ�_������();
		int arr[]={1,3,2,9,10,12};
		System.out.println(a.solution(arr, 7));

	}
	
	 public int solution(int[] scoville, int K) {
	        int answer = 0;
	        
	        PriorityQueue<Integer> q=new PriorityQueue<Integer>();
	        
	        for(int i:scoville)
	            q.add(i);
	        
	        while(!(q.peek()>K)){
	            if(q.size()==1)
	                break;
	            
	            int num1=q.poll();
	            int num2=q.poll();
	            int make=num1+(num2*2);
	            q.offer(make);
	            answer++;
	        }
	       if(q.peek()<K)
	           return -1;
	       
	        return answer;
	    }

}
