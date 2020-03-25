package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {
	private static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < K; i++) {
			dfs(0, N, M);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void dfs(int r, int n, int m) {
		if(r+1 >= n|| r+1>= m) return;
		int temp = map[r][r];
		for (int i = r; i < m-1; i++) {
			map[r][i] = map[r][i+1];
		}
		for (int i = r; i < n-1; i++) {
			map[i][m-1] = map[i+1][m-1];
		}
		for (int i = m-1; i > r; i--) {
			map[n-1][i] = map[n-1][i-1];
		}
		for (int i = n-1; i > r; i--) {
			map[i][r] = map[i-1][r];
		}
		map[r+1][r] = temp;
		
		dfs(r+1, n-1, m-1);
	}
}
