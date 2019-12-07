package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_프린터_이정수 {

	public static void main(String[] args) {
		프로그래머스_프린터_이정수 a= new 프로그래머스_프린터_이정수();

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
	        		if(num<k) { //큐에 가장앞의 원소보다 큰 값이 있는 경우
	        			check=false;
	        		}
	        	}
	        	
	        	if(check) {//가장 앞의 원소보다 큰 값이 없는 경우
	        		if(location==0) {
	        			return count+1;
	        		}
	        		else {
	        			location--;
	        			count++;
	        		}
	        	    
	        		
	        	}else { //check=false인 경우(num보다 큐에 큰 값이 있는 경우)
	        		
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
