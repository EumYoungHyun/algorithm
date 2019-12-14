package sooan;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}
        while(!pq.isEmpty()) {
        	if(pq.size()==1 && pq.peek() < K) return -1;
        	
    		int a = -1;
    		int b = -1;
    		if(!pq.isEmpty()) {
    			a = pq.poll();
    			if(a >= K) break;
    		}
        	if(!pq.isEmpty())
        		b = pq.poll();
        	if((a!=-1 && b!= -1) && (a < K || b < K)) {
        		pq.add(a + (b * 2));
        		answer++;
        	}
        }
        return answer;
    }
}
