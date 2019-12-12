package 프로그래머스;

public class 프로그래머스_라면공장_이정수 {

	public static void main(String[] args) {
		프로그래머스_라면공장_이정수 a=new 프로그래머스_라면공장_이정수();
		int st=4;
		int d[]={1,2,3,4};
		int s[]={10,40,30,20};
		int k=100;
		System.out.println(a.solution(st, d, s, k));

	}
	
	 public int solution(int stock, int[] dates, int[] supplies, int k) {
	        int answer = 0;
	        int day=0;//날짜 인덱스
	        for(int i=1;i<k;i++){//k-1까지만 하면됨
	            stock--;//하루 밀가루 소비
	            
	            if(day==dates.length)
	            	break;
	            if(i==dates[day]){//공급날짜
	                
	                if(day==dates.length-1){//마지막 공급날짜의 경우 day+1을 할 수 없으므로 따로 작성
	                    if(stock<k-dates[day]){
	                        stock+=supplies[day];
	                        answer++;//횟수 추가
	                    }
	                } else{
	                    if(stock<dates[day+1]-dates[day]){
	                        stock+=supplies[day];
	                        answer++;//횟수 추가
	                     }
	                }
	                
	                day++;//공급날짜면 판단 후 다음 공급날짜로 넘어감
	            } else{//공급날짜 아니면 그냥 밀가루 소비
	                continue;
	            }
	            
	        }
	        return answer;
	    }

}
