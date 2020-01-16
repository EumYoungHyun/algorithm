package sungchan;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers_더맵게 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,2,3,9,10,12}, 7));
	}
	
	public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
           public int compare(Integer o1, Integer o2) {
               return o1-o2;
           } 
        });
        
        for(int i=0; i<scoville.length; i++) {
            pqueue.add(scoville[i]);
        }
        
        int count = 0;
        
        while(true) {
            if(pqueue.peek() >= K) {
                break;
            }
            
            if(pqueue.size() <= 1) {
                count = -1;
                break;
            }
            
            int a = pqueue.poll();
            int b = pqueue.poll();
            
            pqueue.add(a + b*2);
            count++;
        }
        
        return count;
    }
}
