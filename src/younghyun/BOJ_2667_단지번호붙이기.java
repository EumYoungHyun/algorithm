package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_2667_단지번호붙이기 {
	private static int count;
	private static int[][] map;
	private static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}
		int result = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 1) {
					count = 0;
					dfs(i,j);
					queue.add(count);
					result++;
				}
			}
		}
		
		System.out.println(result);
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
	public static int[][] dirs = {{-1, 0},{0, -1},{1, 0},{0, 1}};
	public static void dfs(int r, int c) {
		count++;
		map[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = r + dirs[i][0];
			int ny = c + dirs[i][1];
			if(nx >=0 && ny >=0 && nx <N && ny <N && map[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
}
