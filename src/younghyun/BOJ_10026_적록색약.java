package younghyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10026_적록색약 {
	private static char[][] map;
	private static int N, resultRG_B, resultR_G_B;
	private static boolean[][][] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		check = new boolean[2][N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!check[0][i][j]) {
					resultR_G_B++;
					dfsR_G_B(i,j,map[i][j]);
				}
				if(!check[1][i][j]) {
					resultRG_B++;
					dfsRG_B(i,j,map[i][j]);
				}
			}
		}
		System.out.print(resultR_G_B+" ");
		System.out.println(resultRG_B);
	}
	public static void dfsR_G_B(int r, int c, char x) {
		if(x != map[r][c]) return;
		if(check[0][r][c]) return;
		check[0][r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dirs[i][0];
			int nc = c + dirs[i][1];
			if(nr>=0 && nc>=0 && nr<N && nc<N) {
				dfsR_G_B(nr, nc, x);
			}
		}
	}
	public static void dfsRG_B(int r, int c, char x) {
		if(x != map[r][c]) {
			if(x == 'R' && map[r][c] != 'G') return;
			else if (x == 'G' && map[r][c] != 'R') return;
			else if (x == 'B') return;
		}
		if(check[1][r][c]) return;
		check[1][r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dirs[i][0];
			int nc = c + dirs[i][1];
			if(nr>=0 && nc>=0 && nr<N && nc<N) {
				dfsRG_B(nr, nc, x);
			}
		}
	}
	public static int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
}
