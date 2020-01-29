package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2573_빙산 {
	private static int[][] map, copymap;
	private static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		//입력받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copymap = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copymap[i][j] = map[i][j];
			}
		}
		int year = -1;
		while(++year>=0) {

			//조각 수 확인
			boolean zero = true;
			boolean end = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(copymap[i][j] != 0) {
						dfs(i, j);
						if(!zero) {
							end = true;
						}
						zero = false;
					}
				}
			}
			//전부다 0이면 0출력
			if(zero) {
				year = 0;
				break;
			}
			//2조각 이상이면 년수 출력
			if(end) break;

			//copymap 변경
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copymap[i][j] = map[i][j];
				}
			}
			
			//옆에 0인곳 만큼 빼기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					melt(i, j);
				}
			}
			
			//map 변경
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = copymap[i][j];
				}
			}

		}
		System.out.println(year);
	}
	public static void melt(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dirs[i][0];
			int nc = c + dirs[i][1];
			if(nr>=0 && nc >=0 && nr<N && nc<M && map[nr][nc] == 0) {
				copymap[r][c]--;
				if(copymap[r][c] < 0) copymap[r][c] = 0;
			}
		}
	}
	public static int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
	public static void dfs(int r, int c) {
		copymap[r][c] = 0;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dirs[i][0];
			int nc = c + dirs[i][1];
			if(nr>=0 && nc >=0 && nr<N && nc<M && copymap[nr][nc] != 0) {
				dfs(nr, nc);
			}
		}
		
	}
}
