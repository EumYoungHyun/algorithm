package sooan;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2_실패ㅡㅡ {
	private static char[][] map;
	private static boolean[][] visited;
	private static int N;
	private static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int rx = 0 , ry = 0, bx = 0, by =0;
		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char in = str.charAt(j);
				map[i][j] = in;
				if(in=='B') {
					bx = i; by = j;
				}else if(in=='R') {
					rx = i; ry = j;
				}
			}
		}
//		for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		dfs(rx,ry,bx,by,1);
//		System.out.println(min+" : "+isAble);
		if(isAble) System.out.println(min);
		else System.out.println(-1);
		
		
	}//end of main
	public static boolean isAble = true;
	public static int min = Integer.MAX_VALUE;
	public static void dfs(int rx, int ry, int bx, int by, int step) {
		
		int move = 1;
		int nrx = rx, nry = ry+move;
		int nbx = bx, nby = by+move;
		//우
		if(nry < M && map[nrx][nry] != '#' && !visited[nrx][nry]) {
			
			while(map[nrx][nry]!='#') {
				visited[nrx][nry] = true;
				if(map[nrx][nry] == 'O') { //종료 조건
					isAble = true;
					if(min>step) min = step;
					makeOrigin(rx, ry, nrx, nry, 0);
					return;
				}
				nry = ry + move++;
			}
			if(step+1>10) {
				isAble = false;
				makeOrigin(rx, ry, nrx, nry, 0);
				return;
			}
			move = 1;
			while(nbx>=0 && nbx < N && nby>=0 && nby<M
					&& map[nbx][nby]!='#') {
				nby = by + move ++;
				if(map[nbx][nby]=='O') { //파란구슬이 구멍에 들어가는 경우
					isAble = false;
					return;
				}
			}
			dfs(nrx,nry-1,nbx,nby-1,step+1);
			makeOrigin(rx, ry, nrx, nry, 0);
		}
		//하
		move = 1; nrx = rx + move; nry = ry; nbx = bx+move; nby = by;
		if(nrx < N && map[nrx][nry] != '#' && !visited[nrx][nry]) {
			
			while(map[nrx][nry]!='#') {
				visited[nrx][nry] = true;
				if(map[nrx][nry] == 'O') { //종료 조건
					isAble = true;
					if(min>step) min = step;
					makeOrigin(rx, ry, nrx, nry, 1);
					return;
				}
				nrx = rx + move++;
			}
			if(step+1>10) {
				isAble = false;
				makeOrigin(rx, ry, nrx, nry, 1);
				return;
			}
			move = 1;
			while(nbx>=0 && nbx < N && nby>=0 && nby<M
					&& map[nbx][nby]!='#') {
				nbx = bx + move ++;
				if(map[nbx][nby]=='O') { //파란구슬이 구멍에 들어가는 경우
					isAble = false;
					return;
				}
			}
			dfs(nrx-1,nry,nbx-1,nby,step+1);
			makeOrigin(rx, ry, nrx, nry, 1);
		}
		//좌
		move = 1; nrx = rx; nry = ry-move; nbx = bx; nby = by-move;
		if(nry>=0 && map[nrx][nry] != '#' && !visited[nrx][nry]) {
			
			while(map[nrx][nry]!='#') {
				visited[nrx][nry] = true;
				if(map[nrx][nry] == 'O') { //종료 조건
					isAble = true;
					if(min>step) min = step;
					makeOrigin(rx, ry, nrx, nry, 2);
					return;
				}
				nry = ry - move++;
			}
			if(step+1>10) {
				isAble = false;
				makeOrigin(rx, ry, nrx, nry, 2);
				return;
			}
			move = 1;
			while(nbx>=0 && nbx < N && nby>=0 && nby<M
					&& map[nbx][nby]!='#') {
				nby = by - move ++;
				if(map[nbx][nby]=='O') { //파란구슬이 구멍에 들어가는 경우
					isAble = false;
					return;
				}
			}
			dfs(nrx,nry+1,nbx,nby+1,step+1);
			makeOrigin(rx, ry, nrx, nry, 2);
		}
		//상
		move = 1; nrx = rx - move; nry = ry; nbx = bx-move; nby = by;
		if(nrx>=0 && map[nrx][nry] != '#' && !visited[nrx][nry]) {
			
			while(map[nrx][nry]!='#' && (nbx!=nrx && nby!=nry)) {
				visited[nrx][nry] = true;
				if(map[nrx][nry] == 'O') { //종료 조건
					isAble = true;
					if(min>step) min = step;
					makeOrigin(rx, ry, nrx, nry, 3);
					return;
				}
				nrx = rx - move++;
			}
			map[nrx][nry] = 'R';
			if(step+1>10) {
				isAble = false;
				makeOrigin(rx, ry, nrx, nry, 3);
				return;
			}
			move = 1;
			while(nbx>=0 && nbx < N && nby>=0 && nby<M
					&& map[nbx][nby]!='#' && (nbx!=nrx && nby!=nry)) {
				nbx = bx - move ++;
				if(map[nbx][nby]=='O') { //파란구슬이 구멍에 들어가는 경우
					isAble = false;
					return;
				}
			}
			dfs(nrx+1,nry,nbx+1,nby,step+1);
			makeOrigin(rx, ry, nrx, nry, 3);
		}
		
	}//end of method
	private static void makeOrigin(int rx, int ry, int nrx, int nry, int dir) {
		int move = 0;
		int nx = nrx;
		int ny = nry;
		switch (dir) {
		case 0: //우
			while(nry != ry) {
				nry = ny - move++; 
				visited[nrx][nry] = false;
			}
			break;
		case 1: //하
			while(nrx != rx) {
				nrx = nx - move++; 
				visited[nrx][nry] = false;
			}
			break;
		case 2: //좌
			while(nry != ry) {
				nry = ny + move++; 
				visited[nrx][nry] = false;
			}
			break;
		case 3: //상
			while(nrx != rx) {
				nrx = nx + move++; 
				visited[nrx][nry] = false;
			}
			break;

		default:
			break;
		}
		
	}
}













