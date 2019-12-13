package sooan;

import java.util.PriorityQueue;

public class Solution_라면공장 {

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int date = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2) -> o2-o1);
        
        int idx = 0; // dates 배열을 바라보는 변수
        while(date < k){
        	date++;
        	stock--;
        	if(idx < dates.length && date == dates[idx]) {	//내가 지나온 날짜일 경우에만 pq에 공급량 넣기
        		pq.add(supplies[idx++]);
        	}
        	if(stock==0 && date != k) {
        		stock += pq.poll();
        		answer++;
        	}
        }
        return answer;
    }
}
