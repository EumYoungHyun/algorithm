package jongho;
import java.util.*;

//Greedy
public class Solution_prog_42885_구명보트 {
	public static void main(String[] args) {
		int[] triangle = new int[]{70, 50, 80, 50};
		System.out.println(solution(triangle,100));
	}
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
        for(int i=people.length-1, cnt=0; i>=0 && i>=cnt; i--){
            if(people[i]+people[cnt]<=limit){
                answer++; cnt++;
            }else{
                answer++;
            }
        }        
        return answer;
    }
}