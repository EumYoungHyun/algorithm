package jungsoo;
import java.util.*;

class 프로그래머스_가장먼노드_이정수 {
	ArrayList<Integer> list[];
	boolean visited[];
	public int solution(int n, int[][] edge) {
		int answer = 0;
		list = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < edge.length; i++) { // 간선연결
			list[edge[i][0]].add(edge[i][1]);
			list[edge[i][1]].add(edge[i][0]);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			answer = size;
			while (size-- > 0) {
				int temp = q.poll();
				for (int i = 0; i < list[temp].size(); i++) {
					if (visited[list[temp].get(i)])
						continue;
					q.offer(list[temp].get(i));
					visited[list[temp].get(i)] = true;
				}
			}
		}
		return answer;
	}
}