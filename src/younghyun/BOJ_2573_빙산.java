package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {
	private static int count;
	private static int[][] copymap;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		copymap = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copymap[i][j] = map[i][j];
			}
		}
		int days = 0;
		while (true) {
			days++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copymap[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0) {
						int zeroCount = 0;
						for (int k = 0; k < 4; k++) {
							int nx = i + dirs[k][0];
							int ny = j + dirs[k][1];
							if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
								zeroCount++;
							}
						}
						copymap[i][j] -= zeroCount;
						if (copymap[i][j] < 0)
							copymap[i][j] = 0;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = copymap[i][j];
				}
			}

			count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copymap[i][j] != 0) {
						dfs(i, j);
						count++;
					}
					if (count > 1)
						break;
				}
				if (count > 1)
					break;
			}
			if (count != 1)
				break;

		} // end of while
		if (count == 0)
			System.out.println(0);
		else
			System.out.println(days);
	}

	public static int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static void dfs(int i, int j) {
		if (copymap[i][j] != 0) {
			copymap[i][j] = 0;
			for (int k = 0; k < 4; k++) {
				int nx = i + dirs[k][0];
				int ny = j + dirs[k][1];
				if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && copymap[nx][ny] != 0) {
					dfs(nx, ny);
				}
			}
		}
	}
}
