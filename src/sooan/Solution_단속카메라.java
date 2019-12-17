package sooan;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_단속카메라 {
	public static void main(String[] args) {
		Solution_단속카메라 s = new Solution_단속카메라();
		int[][] routes = {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
		s.solution(routes);
	}
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
        int e = routes[0][1]; //첫 인덱스의 끝나는 지점
        for(int i=0; i<routes.length-1; i++){
            if(routes[i][1] < e){ //끝이 전 e보다 작으면 겹치는 것
                e = routes[i][1];
            }
            if(routes[i+1][0] >= e){ //시작이 전 e보다 크면 겹치지 않는 것
                answer++;
                e = routes[i+1][1];
            }
        }
        return answer;
    }
}
