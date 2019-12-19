package younghyun;

import java.util.*;
class programmers_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0, start = 0, end = people.length -1;
        Arrays.sort(people);
        while(start <= end){
            if(people[start++] + people[end--] <= limit) answer++;
            else {
                start--;
                answer++;
            }
        }

        return answer;
    }
}
