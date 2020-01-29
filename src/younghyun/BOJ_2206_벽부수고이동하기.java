package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2206_벽부수고이동하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return 	o1[3]-o2[3];
			}
		});
		queue.add(new Integer[] {0, 0, 1, 1});
		int result = -1;
		while (!queue.isEmpty()) {
			Integer[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			int x = temp[2];
			int cnt = temp[3];
			if(r == N-1 && c == M-1) {
				result = cnt;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dirs[i][0];
				int nc = c + dirs[i][1];
				if(nr>=0 && nr < N && nc>=0 && nc < M && map[nr][nc] == 0) {
					queue.add(new Integer[] {nr, nc, x, cnt+1});
				}
				if(x==0) continue;
				if(nr>=0 && nr < N && nc>=0 && nc < M && map[nr][nc] == 1) {
					queue.add(new Integer[] {nr, nc, 0, cnt+1});
				}
			}
			
		}
		System.out.println(result);
		
	}
	public static int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
}
