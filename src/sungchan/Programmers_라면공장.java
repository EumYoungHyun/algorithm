package sungchan;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers_라면공장 {
	public static void main(String[] args) {
		System.out.println(solution(4, new int[]{4,10,15}, new int[]{20,5,10}, 30));
	}
	
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        
        int curday = 0;
        int count = 0;
        for(int i=0; i<dates.length; i++) {
            stock = stock - (dates[i]-curday);
            
            while(stock < 0) {
                stock = stock + pqueue.poll();
                count++;
            }
            
            pqueue.add(supplies[i]);
            curday = dates[i];
        }
        
        stock = stock - (k-curday);
        
        while(stock < 0) {
            stock = stock + pqueue.poll();
            count++;
        }
        
        return count;
    }
}
