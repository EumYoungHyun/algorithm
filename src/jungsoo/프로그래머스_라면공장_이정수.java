import java.util.*;
class 프로그래머스_라면공장_이정수 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        
        PriorityQueue<Integer> q=new PriorityQueue<>(Comparator.reverseOrder());//supply역순으로 정렬
        int index=0;
        for(int i=0;i<k;i++){
            if(index<dates.length && i==dates[index]){//공급량순으로 내림차순
                q.add(supplies[index]);
                index++;
            }
            
            if(stock==0){//재고가 0이되는 시점에 가장 공급량이 많은애를 공급함
                stock+=q.poll();
                answer++;
            }
            stock--;
        }
        return answer;
    }
}