package jungsoo;
import java.util.*;
class Job implements Comparable<Job> {
    int start;
    int workTime;
    
    public Job(int start, int time) {
        this.start = start;
        this.workTime = time;
    }
    //걸리는 소요시간이 짧을수록, 시작 시간이 짧을 수록 우선수위를 높게함
    @Override
    public int compareTo(Job o) {
        if (this.workTime < o.workTime) return -1;
        else if (this.workTime == o.workTime) {
            if (this.start < o.start) return -1;
            else return 1;
        } else return 1;
    }
}
 
class 프로그래머스_디스크컨트롤러_이정수 {
	
    public int solution(int[][] jobs) {
        PriorityQueue<Job> q = new PriorityQueue<>();
        List<Job> list = new ArrayList<>();
        
        for(int i=0;i<jobs.length;i++)
        	q.offer(new Job(jobs[i][0],jobs[i][1]));
        
        for(int i=0;i<jobs.length;i++)
        	list.add(q.poll());
        
        int time=0;
        int sum=0;       
        while(list.size()>0){
        	for(int i=0;i<list.size();i++){
        		if(time>=list.get(i).start){
        			time+=list.get(i).workTime;
        			sum+=time-list.get(i).start;
        			list.remove(i);
        			break;
        		}
        		if(i==list.size()-1)
        			time++;
        	}
        }
        int answer=sum/jobs.length;
        return answer;
    }
}