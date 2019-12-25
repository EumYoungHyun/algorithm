package younghyun;

public class programmers_주식가격 {
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	label:       for(int i=0; i<prices.length; i++){
	            for(int j=i+1;j<prices.length;j++){
	                if(prices[j] < prices[i]){
	                    answer[i] = j-i;
	                    continue label;
	                }
	            }
	            if(answer[i] == 0) answer[i] = prices.length-i-1;
	        }
	        
	        return answer;
	    }
}
