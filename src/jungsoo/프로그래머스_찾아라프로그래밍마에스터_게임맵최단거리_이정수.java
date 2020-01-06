package jungsoo;

import java.util.*;
public class 프로그래머스_찾아라프로그래밍마에스터_게임맵최단거리_이정수 {
	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	int dr[] = { 0, 1, 0, -1 };
	int dc[] = { 1, 0, -1, 0 };

	public int solution(int[][] maps) {
		int answer = 1;
		int r = maps.length;
		int c = maps[0].length;
		boolean visited[][] = new boolean[r][c];
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[0].length; j++) {
				if (maps[i][j] == 0)
					visited[i][j] = true;
			}
		}
		q.add(new Point(0, 0));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Point p = q.poll();
				for (int i = 0; i < 4; i++) {
					int tempr = p.x + dr[i];
					int tempc = p.y + dc[i];
					if (tempr >= 0 && tempr < r && tempc >= 0 && tempc < c && !visited[tempr][tempc]
							&& maps[tempr][tempc] == 1) {
						if (tempr == r - 1 && tempc == c - 1) {
							answer++;
							return answer;
						}
						visited[tempr][tempc] = true;
						q.add(new Point(tempr, tempc));
					}
				}
			}
			answer++;
		}
		return -1;
	}
}