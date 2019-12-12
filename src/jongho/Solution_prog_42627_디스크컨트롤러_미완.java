package jongho;

import java.util.*;

public class Solution_prog_42627_디스크컨트롤러_미완 {
    public int solution(int[][] jobs) {
        int answer = 0;
        //jobs[][0] : 작업 요청시점, jobs[][1] : 작업 소요시간
        PriorityQueue<job> pq = new PriorityQueue<>();
        for(int i=0;i<jobs.length; i++){
            pq.add(new job(jobs[i][0],jobs[i][1]));
        }
        int time=0;
        int sum=0;
        
        while(!pq.isEmpty()){
            job j = pq.poll();
            time+=j.do_time;
            sum+=(time-j.req_time);
        }
        answer=sum/jobs.length;
        return answer;
    }
    public class job implements Comparable<job>{
        int req_time;
        int do_time;
        public job(int req_time, int do_time){
            this.req_time=req_time; this.do_time=do_time;
        }
        @Override
        public String toString(){
            return req_time+" "+do_time;
        }
        
        @Override
        public int compareTo(job j){
            if(this.req_time==j.req_time){
                if(this.do_time<j.do_time) return 1;
                else if(this.do_time==j.do_time) return 0;
                else return -1;
            }else if(this.req_time>j.req_time) return 1;
            else return -1;
        }
    }
}
