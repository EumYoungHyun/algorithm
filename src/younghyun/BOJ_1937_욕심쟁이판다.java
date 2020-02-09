package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1937_욕심쟁이판다 {
	private static int max, N;
	private static int[][] map;
	
	public static class panda{
		public int r;
		public int c;
		public int days;
		public panda(int r, int c, int days) {
			super();
			this.r = r;
			this.c = c;
			this.days = days;
		}
		@Override
		public String toString() {
			return "panda [r=" + r + ", c=" + c + ", days=" + days + "]";
		}
	}
	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bfs(i, j);
				}
			}
			System.out.println(max);
	}
	public static void bfs(int pr, int pc) {
		Queue<panda> queue = new LinkedList<panda>();
		queue.add(new panda(pr, pc, 1));
		while(!queue.isEmpty()) {
			panda panda = queue.poll();
			if(max < panda.days) max = panda.days;
			for (int i = 0; i < 4; i++) {
				int nr = panda.r + dirs[i][0];
				int nc = panda.c + dirs[i][1];
				if(nr>=0 && nc>=0 && nr<N && nc<N && map[panda.r][panda.c] < map[nr][nc]) {
					queue.add(new panda(nr,nc,panda.days+1));
				}
			}
		}
	}
	public static int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
}
