package 프로그래머스;

import java.util.*;

public class 프로그래머스_네트워크_이정수 {
	int p[];
	int rank[];

	public int solution(int n, int[][] computers) {
		int answer = 0;
		p = new int[n];
		rank = new int[n];

		for (int i = 0; i < n; i++) {
			p[i] = i;
			rank[i] = 0;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				// link
				if (computers[i][j] == 1) {
					if (find(i) != find(j)) {
						union(i, j);
					}
				}
			}
		}

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++)
			set.add(find(i));

		answer = set.size();
		return answer;
	}

	public int find(int x) {
		if (p[x] == x) {
			return p[x];
		} else {
			int px = find(p[x]);
			return px;
		}
	}

	public void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (rank[px] > rank[py]) {
			p[py] = px;
		} else {
			p[px] = py;
			if (rank[px] == rank[py])
				rank[py]++;
		}
	}
}
