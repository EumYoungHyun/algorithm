package sungchan;

public class Programmers_1차추석트래픽 {
	public static void main(String[] args) {
		String lines[] = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
		System.out.println(solution(lines));
	}
	
	public static int solution(String[] lines) {
	      
	      int max = 0; // 최대 나올 수 있는 갯수
	      
	      for(int i=0; i<lines.length; i++) {
	          String times[] = lines[i].split(" ")[1].split(":");
	          double time = Integer.valueOf(times[0])*3600 + Integer.valueOf(times[1])*60 + Integer.valueOf(times[2].split("\\.")[0]) + Integer.valueOf(times[2].split("\\.")[1])/1000.0;
	          // times[0] => 시간, times[1] => 분, times[2] => 초
	          double spend = Double.valueOf(lines[i].split(" ")[2].replace("s", ""));
	          
	          double range = time + 1; // 트래픽이 끝날 때부터 +1초
	          int count = 1; // 트래픽 디폴트값은 1
	          
	          for(int j=i+1; j<lines.length; j++) {
	              times = lines[j].split(" ")[1].split(":");
	              time = Integer.valueOf(times[0])*3600 + Integer.valueOf(times[1])*60 + Integer.valueOf(times[2].split("\\.")[0]) + Integer.valueOf(times[2].split("\\.")[1])/1000.0;
	              spend = Double.valueOf(lines[j].split(" ")[2].replace("s", ""));
	              
	              double target = Math.round((time - spend + 0.001)*1000.0)/1000.0;
	              // i+1번째 부터 트래픽의 시작시간 구하기
	              // i+1번째부터는 모든 트래픽 끝나는 시간이 오름차순이기 때문에 range의 값보다 i+1번째의 트래픽 시작시간이 작다면 항상 겹치는 범위
	              
	              if(range > target) {
	                  count++;
	              }
	          }
	          
	          max = Math.max(max,count);
	      }
	      
	      return max;
	  }
}
