package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638_치즈 {
	private static int[][] checkmap, copymap;
	private static int M, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		copymap = new int[N][M];
	
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = -1;
		while(++time >= 0) {
			// time check (치즈가 없을 시 break)
			boolean cheese = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						cheese = true;
						break;
					}
				}
			}
			if(!cheese) break;
			// copymap, map 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copymap[i][j] = map[i][j];
				}
			}
			// copymap 0,0에서 BFS 시작 (2로 전환)
			Queue<Integer[]> queue = new LinkedList<Integer[]>();
			queue.add(new Integer[] {0,0});
			while(!queue.isEmpty()) {
				Integer[] temp = queue.poll();
				int r = temp[0];
				int c = temp[1];
				for (int i = 0; i < 4; i++) {
					int nr = r + dirs[i][0];
					int nc = c + dirs[i][1];
					if(nr>=0 && nc >=0 && nr <N && nc <M && copymap[nr][nc]==0) {
						copymap[nr][nc] = 2;
						queue.add(new Integer[] {nr,nc});
					}
				}
			}
			// int 형 checkmap 선언
			checkmap = new int[N][M];
			// copymap에 치즈부분(1) checkmap에 2가 닿는 횟수  저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					check(i,j);
				}
			}
			// checkmap이 2인부분 map에서 0으로 초기화
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(checkmap[i][j] >= 2) {
						map[i][j] = 0;
					}
				}
			}
		}
		System.out.println(time);
	}
	public static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void check(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dirs[i][0];
			int nc = c + dirs[i][1];
			if(nr>=0 && nc>=0 && nr<N && nc<M && copymap[nr][nc] == 2) {
				checkmap[r][c]++;
			}
		}
	}
}
