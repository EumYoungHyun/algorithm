package sungchan;
import java.util.Arrays;

public class Programmers_구명보트 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
		System.out.println(solution(new int[]{70, 80, 50}, 100));
	}
	
	public static int solution(int[] people, int limit) {
        Arrays.sort(people);  
        
        int start = 0;
        int end = people.length-1;
        int count = 0;
        
        while(end > start) {
            if(people[end] + people[start] <= limit) {
                start++;
            }
            end--;
            count++;
        }
        
        if(start == end) {
            count++;
        }
        
        return count;
    }
}
