package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16988_Baaaaaaaaaduk2_Easy {
	private static int max, count, N, M;
	private static boolean flag;
	private static int[][] map;
	private static int[][] copymap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copymap = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					myturn(i, j);
			}
		}
		System.out.println(max);
	}

	private static void myturn(int r, int c) {
		map[r][c] = 1;

		for (int i = r; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					for (int rx = 0; rx < N; rx++) {
						for (int ry = 0; ry < M; ry++) {
							copymap[rx][ry] = map[rx][ry];
						}
					}
					searching();
					map[i][j] = 0;
				}
			}
		}
	}

	private static void searching() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 2) {
					count = 0;
					flag = true;
					dfs(i, j);
					if (flag) 
						if(max < count) 
							max = count;
				}
			}
		}
	}
	private int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
	private static void dfs(int r, int c) {
		if(map[r][c] == 0) {
			flag = false;
			return;
		}
		if(map[r][c] == 1) return;
		copymap[r][c] = 0;
		
	}
}
