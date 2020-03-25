package jongho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_boj_10026_적록색약 {
	public static int N;
	public static boolean [][] visited;
	public static char [][] m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 그리드의 크기, N*N 1<=N<=100
		m = new char[N][N];	// 그리드[행][열]
		for(int i=0; i<N; i++) {
			String str = br.readLine();
//			m[i] = str.toCharArray();	// 단점 : 배열의 메모리를 별도로 생성(시간, 메모리) 장점 : 복붙이 빠름
			for(int j=0; j<N; j++) {
				m[i][j]=str.charAt(j);
			}
		}

		visited = new boolean[N][N];
		int cnt=0;
		// 정상 : 모든 좌표를 돌며 방문하지 않은 좌표는 dfs 시작
		for(int i=0; i<N; i++) {	// 정상인의 구획수
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					cnt++;
					dfs(i,j);
				}
			}
		}
		
		// RGB m 배열에서 G -> R
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(m[i][j] == 'G') {
					m[i][j] = 'R';
				}
			}
		}
		// 색약 : 모든 좌표를 돌며, 방문하지 않은 좌표는 dfs를 시작
		// visited = new boolean[N][N]; 	// 새 객체생성 : 시간손해 큼
		for(int i=0; i<N; i++) {			// 초기화가 더 빠름
			Arrays.fill(visited[i], false);
//			for(int j=0; j<N; j++) {
//				visited[i][j]=false;
//			}
		}
		
		int cnt2=0;
		for(int i=0; i<N; i++) {	// 색약인의 구획수
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					cnt2++;
					dfs(i,j);
				}
			}
		}
		
		System.out.println(cnt + " " + cnt2);
		
	}// end of main
	public static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	public static int[] dc = {0, 0, -1, 1}; // 상하좌우
	public static void dfs(int r, int c) {
		visited[r][c]=true;
		for(int i=0; i<dr.length; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && m[nr][nc] == m[r][c]) {
				dfs(nr, nc);
			}
		}
	}
}
