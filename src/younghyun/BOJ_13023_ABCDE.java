package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {
	private static boolean[][] map;
	private static boolean result;
	private static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new boolean[N][N];
		check = new boolean[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			map[b][a] = true;
		}
		for (int i = 0; i < N; i++) {
			if(!result) {
				check[i] = true;
				dfs(i, 1);
				check[i] = false;
			}
		}
		if(result) System.out.println(1);
		else System.out.println(0);
	}// end of main

	public static void dfs(int i, int d) {
		if(d >= 5) result = true;
		if(result) return;
		for (int j = 0; j < map.length; j++) {
			if(check[j]||!map[i][j]) continue;
			check[j] = true;
			dfs(j, d+1);
			check[j] = false;
		}
	}
}
