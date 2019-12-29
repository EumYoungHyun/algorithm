package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_12100_2048Easy {
	private static int[][] map;
	private static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(max);
		
	}
	public static void dfs(int step) {
		if(step >= 5) {
			int num = 0;
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map.length; j++) {
						if(num < map[i][j]) num = map[i][j];
					}
				}
			if(max < num) {
//				for (int[] is : map) {
//					System.out.println(Arrays.toString(is));
//				}
				max = num;
			}
			return;
		}
		int[][] copymap = new int[map.length][map.length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				copymap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < 4; i++) {
			move(i);
			dfs(step+1);
			for (int j = 0; j < copymap.length; j++) {
				for (int k = 0; k < copymap.length; k++) {
					map[j][k] = copymap[j][k];
				}
			}
		}
	}
	public static void move(int dir) {
		class board {
			public int val;
			public boolean change;
			public board(int val, boolean change) {
				super();
				this.val = val;
				this.change = change;
			}
			@Override
			public String toString() {
				return "board [val=" + val + ", change=" + change + "]";
			}
			
		}
		Deque<board> queue = new LinkedList<board>();

		switch (dir) {
		// 상
		case 0:
			for (int j = 0; j < map.length; j++) {
				for (int i = 0; i < map.length; i++) {
					if(map[i][j] != 0 && (queue.isEmpty() || queue.peekLast().val != map[i][j])) {
						queue.add(new board(map[i][j], false));
						map[i][j] = 0;
					}else if(map[i][j] != 0 && queue.peekLast().val == map[i][j] && !queue.peekLast().change) {
						queue.peekLast().val *=2;
						queue.peekLast().change = true;
						map[i][j] = 0;
					}else {
						queue.add(new board(map[i][j], false));
						map[i][j] = 0;
					}
				}
				int idx = -1;
				while(!queue.isEmpty()) {
					map[++idx][j] = queue.poll().val;
				}
			}
			break;
		// 하
		case 1:
			for (int j = 0; j < map.length; j++) {
				for (int i = map.length-1; i >= 0; i--) {
					if(map[i][j] != 0 && (queue.isEmpty() || queue.peekLast().val != map[i][j])) {
						queue.add(new board(map[i][j], false));
						map[i][j] = 0;
					}else if(map[i][j] != 0 && queue.peekLast().val == map[i][j] && !queue.peekLast().change) {
						queue.peekLast().val *=2;
						queue.peekLast().change = true;
						map[i][j] = 0;
					}else {
						queue.add(new board(map[i][j], false));
						map[i][j] = 0;
					}
				}
				int idx = map.length;
				while(!queue.isEmpty()) {
					map[--idx][j] = queue.poll().val;
				}
			}
			break;
		// 좌
		case 2:
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j] != 0 && (queue.isEmpty() || queue.peekLast().val != map[i][j])) {
						queue.add(new board(map[i][j], false));
						map[i][j] = 0;
					}else if(map[i][j] != 0 && queue.peekLast().val == map[i][j] && !queue.peekLast().change) {
						queue.peekLast().val *=2;
						queue.peekLast().change = true;
						map[i][j] = 0;
					}else if(map[i][j] != 0) {
						queue.add(new board(map[i][j], false));
						map[i][j] = 0;
					}
				}
				int idx = -1;
				while(!queue.isEmpty()) {
					map[i][++idx] = queue.poll().val;
				}
			}
			break;
		// 우
		case 3:
			for (int i = 0; i < map.length; i++) {
				for (int j = map.length-1; j >= 0; j--) {
					if(map[i][j] != 0 && (queue.isEmpty() || queue.peekLast().val != map[i][j])) {
						queue.add(new board(map[i][j], false));
						map[i][j] = 0;
					}else if(map[i][j] != 0 && queue.peekLast().val == map[i][j] && !queue.peekLast().change) {
						queue.peekLast().val *=2;
						queue.peekLast().change = true;
						map[i][j] = 0;
					}else {
						queue.add(new board(map[i][j], false));
						map[i][j] = 0;
					}
				}
				int idx = map.length;
				while(!queue.isEmpty()) {
					map[i][--idx] = queue.poll().val;
				}
			}
			break;
		}
	}
}
