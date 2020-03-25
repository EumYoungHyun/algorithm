package sungchan;

public class Programmers_입국심사 {
	public static void main(String[] args) {
		System.out.println(solution(6, new int[]{7,10}));
	}
	
	public static long solution(int n, int[] times) {
        long start = 1;
        long end = 1000000000;
        long result = Long.MAX_VALUE;
        
        while(end >= start) {
        	long mid = (start+end)/2;
        	
        	long sum = 0;
        	for(int i=0; i<times.length; i++) {
        		sum = sum + mid/times[i];
        	}
        	
        	if(sum < n) {
        		start = mid+1;
        	} else {
        		result = Math.min(result, mid);
        		end = mid-1;
        	} 
        }
        
        return result;
    }
}
