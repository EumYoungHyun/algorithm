import java.util.*;
class 프로그래머스_구명보트_이정수 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        boolean visited[]=new boolean[people.length];
        Arrays.sort(people);
        int sum=0;
        int temp=0;
        for(int i=0;i<people.length;i++){
            if(visited[i])
                continue;
            visited[i]=true;
            int num=people[i];
            for(int j=people.length-1-temp;j>0;j--){
                if(visited[j])
                    continue;
                if(num+people[j]<=limit){
                    visited[j]=true;
                    temp++;
                    break;
                } else{
                    visited[j]=true;
                    answer++;
                    temp++;
                }
            }

            answer++;
        }

        return answer;
    }

}