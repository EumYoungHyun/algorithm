package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17837_새로운게임2 {
	static class horse{
		public int r;
		public int c;
		public int dir;
		public horse(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// 체스판 크기
		int N = Integer.parseInt(st.nextToken());
		// 말의 개수
		int K = Integer.parseInt(st.nextToken());
		int[][] imap = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				imap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 행, 열 , 번호 (1 우, 2 좌, 3 상, 4 하)
		horse[] list = new horse[K];
		Stack<horse>[][] smap = new Stack[N][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			list[i] = new horse(r, c, dir);
			smap[r][c].add(list[i]);
		}
		// 턴이 진행되던 중에 말이 4개 쌓이는 순간 게임이 종료된다.
		// 1000턴 넘게 진행되면 -1을 출력한다
		int result = -1;
		for (int turn = 0; turn < 1000; turn++) {
			for (int i = 0; i < K; i++) {
				int nr= list[i].r+dirs[list[i].dir][0];
				int nc= list[i].r+dirs[list[i].dir][1];
				if(imap[nr][nc] == 2 || nr <0 || nc <0 || nr >=N || nc>=N) {
					list[i].dir = list[i].dir%2 == 0? list[i].dir-1:list[i].dir+1;
					nr= list[i].r+dirs[list[i].dir][0];
					nc= list[i].r+dirs[list[i].dir][1];					
				}
				
			}
		}
		System.out.println(result);
	}
	// 우 , 좌 , 상 , 하
	public static int[][] dirs = {{},{0, 1},{0, -1},{-1, 0},{1, 0}};
}
