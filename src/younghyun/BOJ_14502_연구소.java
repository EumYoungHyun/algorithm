package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
	private static LinkedList<Integer> list;
	private static int[] wall;
	private static int[][] map, copymap;
	private static boolean[][] chkmap;
	private static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new  int[N][M];
		list = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					list.add(10*i+j);
				}
			}
		}
		// nC3 comb
		wall = new int[3];
		comb(list.size(), 3);
		System.out.println(max);
	}
	public static void comb(int n, int r) {
		if(r == 0) {
			copymap = new int[map.length][map[0].length];
			for (int i = 0; i < copymap.length; i++) {
				for (int j = 0; j < copymap[0].length; j++) {
					copymap[i][j] = map[i][j];
				}
			}
			for (int i = 0; i < 3; i++) {
				copymap[wall[i]/10][wall[i]%10] = 1;
			}
			chkmap = new boolean[map.length][map[0].length];
			//주변이 0 이면 퍼지는 dfs
			for (int i = 0; i < copymap.length; i++) {
				for (int j = 0; j < copymap[0].length; j++) {
					if(copymap[i][j] == 2 && !chkmap[i][j]) {
						chkmap[i][j] = true;
						dfs(i, j);
					}
				}
			}
			int cnt = 0;
			//안전영역 카운팅
			for (int i = 0; i < chkmap.length; i++) {
				for (int j = 0; j < chkmap[0].length; j++) {
					if(copymap[i][j]==0) cnt++; 
				}
			}
			if(max < cnt) max = cnt;
			return;
		}
		if(n<r) return;
		wall[r-1] = list.get(n-1);
		comb(n-1, r-1);
		comb(n-1, r);
	}
	public static int[][] dirs = {{-1, 0},{0, -1}, {1, 0}, {0, 1}};
	public static void dfs(int i, int j) {
		for (int k = 0; k < 4; k++) {
			int ni = i + dirs[k][0];
			int nj = j + dirs[k][1];
			if(ni >=0 && ni < map.length && nj >=0 && nj < map[0].length
					&& copymap[ni][nj] == 0) {
				chkmap[ni][nj] = true;
				copymap[ni][nj] = 2;
				dfs(ni, nj);
			}
		}
	}
	
}
