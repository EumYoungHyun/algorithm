package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[2] - o2[2];
			}
		});
		queue.add(new Integer[] {0, 0, 1});
		int[][] check = new int[N][M];
		int answer = 0;
		while(!queue.isEmpty()) {
			Integer[] temp = queue.poll();
			if(temp[0] == N-1 && temp[1] == M-1) {
				answer = temp[2];
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dirs[i][0];
				int ny = temp[1] + dirs[i][1];
				if(nx >= 0 && nx < N && ny >=0 && ny < M 
						&& map[nx][ny] == 1 
						&& (check[nx][ny] == 0 || check[nx][ny] > temp[2])) {
					check[nx][ny]= temp[2];
					queue.add(new Integer[] {nx, ny, temp[2]+1});
				}
			}
		}
		System.out.println(answer);
	}
	public static int[][] dirs = {{-1, 0},{0, -1},{1, 0},{0, 1}};
}
