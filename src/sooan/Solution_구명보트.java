package sooan;

import java.util.Arrays;

public class Solution_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
		Arrays.sort(people);
		int s = 0;
		int e = 0;
        for(e = people.length-1; e > s; e--) {
            if(people[s] + people[e] > limit) { //limit을 넘으면 e번째는 혼자 타야함
                answer++;
            }else { //넘지 않으면 s & e 같이 타는 것
                s++;
                answer++;
            }
        }
        if(s==e) {
            answer++;
        }
		return answer;
    }
}
