package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593_상범빌딩 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(L == 0 && R == 0 && C == 0) break;
			boolean[][][] building = new boolean[L][R][C];
			int[] start = new int[3];
			int[] end = new int[3];
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str = br.readLine();
					for (int k = 0; k < C; k++) {
						char ch = str.charAt(k);
						if(ch == '.') building[i][j][k] = true;
						else if(ch == 'S') {
							start[0] = i;
							start[1] = j;
							start[2] = k;
							building[i][j][k] = true;
						}else if (ch == 'E') {
							end[0] = i;
							end[1] = j;
							end[2] = k;
							building[i][j][k] = true;
						}
					}
				}
				String space = br.readLine();
			}
			Queue<Integer[]> queue = new LinkedList<Integer[]>();
			boolean[][][] check = new boolean[L][R][C];
			queue.add(new Integer[] {start[0], start[1], start[2], 0});
			int min = Integer.MAX_VALUE;
			while (!queue.isEmpty()) {
				int r = queue.peek()[1];
				int c = queue.peek()[2];
				int z = queue.peek()[0];
				int score = queue.poll()[3];
				if(min <= score) continue;
				if(r == end[1] && c == end[2] && z == end[0]) {
					min = score;
				}
				for (int i = 0; i < 6; i++) {
					int nr = r + dirs[i][0];
					int nc = c + dirs[i][1];
					int nz = z + dirs[i][2];
					if(nr>=0 && nc>=0 && nz>=0 && nz<L && nr<R && nc<C 
							&& !check[nz][nr][nc] && building[nz][nr][nc]) {
						check[nz][nr][nc] = true;
						queue.add(new Integer[] {nz, nr, nc, score+1});
					}
				}
			}
			if(min == Integer.MAX_VALUE) sb.append("Trapped!\n");
			else {
				sb.append("Escaped in ");
				sb.append(min);
				sb.append(" minute(s).\n");
			}
		}// end of tc
		System.out.println(sb);
	}
	public static int[][] dirs = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
}
