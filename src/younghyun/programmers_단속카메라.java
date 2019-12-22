package younghyun;

import java.util.Arrays;
import java.util.Comparator;

class programmers_단속카메라 {
	public static void main(String[] args) {
		programmers_단속카메라 s = new programmers_단속카메라();
		System.out.println(s.solution(new int[][] {{-21, 3},{4, 10}, {-11, 10}, {-24, 23}}));
	}
	public int solution(int[][] routes) {
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
        int answer = 1;
        int camera = routes[0][1];
        for (int i = 0; i < routes.length; i++) {
			if(camera <= routes[i][0]) {
				camera = routes[i][1];
				answer++;
			}
		}
        return answer;
    }
}
