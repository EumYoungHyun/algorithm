package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17822_원판돌리기 {
	private static int x, k;
	private static int[][] circle;
	private static int N, M;
	private static boolean[][] check;
	private static boolean change;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 원판의 개수
		M = Integer.parseInt(st.nextToken()); // 각 원판의 숫자 개수
		int T = Integer.parseInt(st.nextToken()); // 회전 수

		circle = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (T-- > 0) {// 회전만큼 반복

			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken()); // 움직이는 원판 지정 숫자
			int d = Integer.parseInt(st.nextToken()); // 회전 방향
			k = Integer.parseInt(st.nextToken()); // 회전량
			// 회전 방향을 시계방향으로 통일
			if (d == 1) {
				k = M - k;
			}

			// 1) 원판 회전
			turn();
			// 2) dfs 같은수 삭제 (0으로 만들기)
			check = new boolean[N][M];
			change = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					dfs(i, j, circle[i][j]);
				}
			}
			if (!change) {
				// 3) 체크 안된 애들끼리 평균내고 비교 (배열 1줄씩 정리 (0은 무시하고 진행))
				avg();
			}

		}
		// 전체 숫자 합산 후 출력
		int total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				total += circle[i][j];
			}
		}
		System.out.println(total);
	}// end of main

	public static void turn() {
		for (int i = x - 1; i < N; i += x) {
			// 배열 뒷부분 자르기
			int[] temp = new int[k];
			for (int j = 0; j < temp.length; j++) {
				temp[k - j - 1] = circle[i][M - j - 1];
			}
			// 남은 배열부분 당기기
			for (int j = M - 1; j >= k; j--) {
				circle[i][j] = circle[i][j - k];
			}
			// 빈곳에 잘랐던 뒷부분 붙히기
			for (int j = 0; j < temp.length; j++) {
				circle[i][j] = temp[j];
			}
		}
	}

	public static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void dfs(int r, int c, int val) {
		check[r][c] = true;
		boolean flag = false;
		for (int i = 0; i < dirs.length; i++) {
			int nr = r + dirs[i][0];
			int nc = c + dirs[i][1];
			if (nc == M)
				nc = 0;
			if (nc == -1)
				nc = M - 1;
			if (nr >= 0 && nr < N && circle[nr][nc] != 0 && circle[nr][nc] == val
					&& !check[nr][nc]) {
				circle[nr][nc] = 0;
				change = true;
				flag = true;
				dfs(nr, nc, val);
			}
		}
		if (flag)
			circle[r][c] = 0;
	}

	public static void avg() {
		int avg = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (circle[i][j] != 0) {
					avg += circle[i][j];
					cnt++;
				}
			}
		}
		if(cnt == 0) return;
		if(avg%cnt !=0) {
			avg/=cnt;
			double check;
			check = avg+0.5;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(circle[i][j] == 0) continue;
					if (circle[i][j] > check)
						circle[i][j]--;
					else
						circle[i][j]++;
				}
			}
			
		}else {
			avg/=cnt;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (circle[i][j] != 0 && circle[i][j] < avg)
						circle[i][j]++;
					if (circle[i][j] != 0 && circle[i][j] > avg)
						circle[i][j]--;
				}
			}
		}
	}
}
