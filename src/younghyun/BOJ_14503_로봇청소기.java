package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14503_로봇청소기 {
	static class robot {
		int r;
		int c;
		// dir -> 0: 북, 1: 동, 2: 남, 3: 서
		int dir;

		public robot(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "robot [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
		
	}

	public static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		robot r = new robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		label: while (true) {
			// 현재 위치를 청소한다
			if(map[r.r][r.c]==0) { 
				map[r.r][r.c] = 2;
				result++;
			}
			// 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 한다.
			// 왼쪽방향의 공간이 아직 청소하지 않은곳이라면 그방향으로 회전한 후 1번부터 진행한다.
			for (int i = 0; i < 4; i++) {
				r.dir--;
				if (r.dir == -1)
					r.dir = 3;
				int nr = r.r + dirs[r.dir][0];
				int nc = r.c + dirs[r.dir][1];
				if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
					r.r = nr;
					r.c = nc;
					continue label;
				}
			}
			// 돌다보니 모두 청소할 곳이 없다면 , 바라보는 방향을 유지하고 후진한다.
			// 후진못하면 종료
			int nr = r.r - dirs[r.dir][0];
			int nc = r.c - dirs[r.dir][1];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 1)
				break;
			r.r = nr;
			r.c = nc;

		}
		System.out.println(result);
	}

}
