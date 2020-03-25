package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16985_Maaaaaaaaaze2 {
	private static int[] arr;
	private static int min = Integer.MAX_VALUE;
	private static int[][][] cube;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cube = new int[5][5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++) {
					cube[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = i;
		}
		dfs(5, 0);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}

	public static void dfs(int n, int r) {
		if (r >= 5) {
			for (int c1 = 0; c1 < 4; c1++) {
				for (int c2 = 0; c2 < 4; c2++) {
					for (int c3 = 0; c3 < 4; c3++) {
						for (int c4 = 0; c4 < 4; c4++) {
							for (int c5 = 0; c5 < 4; c5++) {
								if (cube[arr[0]][0][0] == 1)
									bfs();
								turn(4);
							}
							turn(3);
						}
						turn(2);
					}
					turn(1);
				}
				turn(0);
			}
		}
		for (int i = r; i < 5; i++) {
			int temp = arr[i];
			arr[i] = arr[r];
			arr[r] = temp;
			dfs(n, r + 1);
			temp = arr[i];
			arr[i] = arr[r];
			arr[r] = temp;
		}
	}

	public static void bfs() {
		Queue<Integer[]> queue = new LinkedList<Integer[]>();	
		queue.add(new Integer[] { 0, 0, 0, 0 });
		boolean[][][] check = new boolean[5][5][5];

		while (!queue.isEmpty()) {
			int r = queue.peek()[0];
			int c = queue.peek()[1];
			int z = queue.peek()[2];
			int score = queue.poll()[3];
			if (check[r][c][z])
				continue;
			if (r == 4 && c == 4 && z == 4 && min > score) {
				min = score;
				break;
			}
			check[r][c][z] = true;
			for (int i = 0; i < dirs.length; i++) {
				int nr = r + dirs[i][0];
				int nc = c + dirs[i][1];
				int nz = z + dirs[i][2];
				if (nr >= 0 && nc >= 0 && nz >= 0 && nr < 5 && nc < 5 && nz < 5 && cube[arr[nr]][nc][nz] == 1) {
					queue.add(new Integer[] { nr, nc, nz, score + 1 });
				}
			}
		}
	}

	public static void turn(int r) {
		int[][] temp = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp[i][j] = cube[r][4 - j][i];
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				cube[r][i][j] = temp[i][j];
			}
		}
	}
	public static int[][] dirs = { { -1, 0, 0 }, { 1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
}
