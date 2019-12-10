package jongho;
import java.util.*;
public class Solution_prog_42586_기능개발 {
    public static Queue<Integer> q;
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answers = new int[101];
        int[] answer;
        int day;
        q=new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            int cnt = 100-progresses[i];
            if(cnt%speeds[i]!=0) cnt=(cnt/speeds[i])+1;
            else cnt/=speeds[i];
            q.add(cnt);
        }
        day=q.peek();
        int cnt=0, acnt=0;
        while(!q.isEmpty()){
        	System.out.println(q);
            if(day>=q.peek()){
            	q.poll();
                cnt++;
            }
            else {
                answers[acnt++]=cnt;
                cnt=1;
                day=q.poll();
            }
        }
        if(cnt!=0) { answers[acnt++]=cnt; }
        answer=new int[acnt];
        for(int i=0; i<acnt; i++) {
        	answer[i]=answers[i];
        }
        return answer;
    }
}
