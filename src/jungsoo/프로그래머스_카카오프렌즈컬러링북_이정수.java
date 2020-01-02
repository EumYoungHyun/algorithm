package jungsoo;

public class 프로그래머스_카카오프렌즈컬러링북_이정수 {
	int dr[] = { 0, 1, 0, -1 };
	int dc[] = { 1, 0, -1, 0 };
	boolean visited[][];
	int count;

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		visited = new boolean[m][n];
		int[] answer = new int[2];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && picture[i][j] != 0) {
					count = 1;
					int temp = picture[i][j];
					visited[i][j] = true;
					dfs(i, j, count, m, n, picture, temp);
					numberOfArea++;
				}
			}
		}
		answer[0] = numberOfArea;
		answer[1] = max;
		return answer;
	}
	int max = 0;
	public void dfs(int r, int c, int cnt, int m, int n, int[][] pic, int temp) {
		if (max < cnt)
			max = cnt;

		for (int i = 0; i < 4; i++) {
			int tempr = r + dr[i];
			int tempc = c + dc[i];
			if (tempr >= 0 && tempr < m && tempc >= 0 && tempc < n && !visited[tempr][tempc] && pic[tempr][tempc] == temp) {
				visited[tempr][tempc] = true;
				count++;
				dfs(tempr, tempc, count, m, n, pic, temp);
			}
		}
	}
}