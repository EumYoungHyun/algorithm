package ���α׷��ӽ�;

import java.util.LinkedList;
import java.util.Queue;

public class ���α׷��ӽ�_������_������ {

	public static void main(String[] args) {
		���α׷��ӽ�_������_������ a= new ���α׷��ӽ�_������_������();

	}
	
	 public int solution(int[] priorities, int location) {
	        int answer = 0;
	        int count=0;
	        Queue<Integer> q=new LinkedList<Integer>();
	        for(int s:priorities)
	        	q.offer(s);    
	        
	        while(!q.isEmpty()) {
	        	
	        	int num=q.poll();
	        	
	        	boolean check=true;
	        	for(int k:q) {
	        		if(num<k) { //ť�� ������� ���Һ��� ū ���� �ִ� ���
	        			check=false;
	        		}
	        	}
	        	
	        	if(check) {//���� ���� ���Һ��� ū ���� ���� ���
	        		if(location==0) {
	        			return count+1;
	        		}
	        		else {
	        			location--;
	        			count++;
	        		}
	        	    
	        		
	        	}else { //check=false�� ���(num���� ť�� ū ���� �ִ� ���)
	        		
	        		q.offer(num);
	        		location--;
	        		if(location<0) {
	        			location=q.size()-1;
	        		}
	        	}
	        }
	       
	   
	  
	        
	        return answer;
	    }

}
