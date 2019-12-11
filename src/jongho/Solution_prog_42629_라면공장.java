package jongho;

import java.util.*;

public class Solution_prog_42629_라면공장 {
	public static void main(String[] args) {
		int[] s = new int[] { 4,10,15 };
		int[] s2 = new int[] { 20,5,10 };
		System.out.println(solution(4, s, s2, 30));
	}

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new comp());
        int i=0;
        while(stock<k){
            for(; i<dates.length; i++){
                if(stock>=dates[i]){
                    pq.add(supplies[i]);
                }else break;
            }
            stock+=pq.poll();
            answer++;
        }
        return answer;
    }
    
    static class comp implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}    	
    }
}
