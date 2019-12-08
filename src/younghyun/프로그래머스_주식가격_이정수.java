package 프로그래머스;

public class 프로그래머스_주식가격_이정수 {
	
	 public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        
	        for(int i=0;i<prices.length;i++){
	            int cnt=0;
	            boolean flag=false;
	            for(int j=i+1;j<prices.length;j++){
	                if(prices[i]>prices[j]){//가격이 떨어지는 순간
	                    cnt++;//떨어지는 순간 현재 1초간 이 떨어지지않으므로 1초 추가
	                    answer[i]=cnt;
	                    flag=true;
	                    break;
	                } else{//가격이 안떨어지고 유지되는 중
	                    cnt++;
	                }
	            }
	            if(!flag){//끝까지 계속 안떨어지는 경우
	               answer[i]=cnt;
	            }
	        } 
	        return answer;
	    }

}
