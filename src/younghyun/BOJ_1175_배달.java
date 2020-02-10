package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1175_배달 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		int[] start = new int[2];
		int[][] end = new int[2][2];
		end[0][0] = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='S') {
					start[0] = i;
					start[1] = j;
				}
				if(map[i][j]=='C') {
					if(end[0][0] == Integer.MAX_VALUE) {
						end[0][0] = i;
						end[0][1] = j;
					}else {
						end[1][0] = i;
						end[1][1] = j;
					}
				}
			}
		}
		Queue<Integer[]> queue = new LinkedList<>();
		boolean[][][][][] check = new boolean[N][M][2][2][4];
		//r, c, count, dir, goal1, goal2
		queue.add(new Integer[] {start[0], start[1], 0, 0, 0, 0});
		queue.add(new Integer[] {start[0], start[1], 0, 1, 0, 0});
		int min = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			int r = queue.peek()[0];
			int c = queue.peek()[1];
			int count = queue.peek()[2];
			int dir = queue.peek()[3];
			int goal1 = queue.peek()[4];
			int goal2 = queue.poll()[5];
			if(count >= min) continue;
			if(goal1 == 0) 
				if(r == end[0][0] && c == end[0][1]) 
					goal1 = 1;
			if(goal2 == 0) 
				if(r == end[1][0] && c == end[1][1]) 
					goal2 = 1;
			if(goal1 * goal2 == 1) {
				if(min>count)
					min = count;
			}
			for (int i = 0; i < 4; i++) {
				if(i == dir) continue;
				int nr = r + dirs[i][0];
				int nc = c + dirs[i][1];
				if(nr>=0 && nc>=0 && nr<N && nc<M && !check[nr][nc][goal1][goal2][i]&& map[nr][nc]!='#') {
					check[nr][nc][goal1][goal2][i] = true;
					queue.add(new Integer[] {nr, nc, count+1, i, goal1, goal2});
				}
			}
		}
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	public static int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
}