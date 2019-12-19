package sooan;

public class Solution_네트워크 {
	public static void main(String[] args) {
		Solution_네트워크 s = new Solution_네트워크();
		int n = 5;
		int[][] computers = {{1,1,0,0,0},{1,1,1,0,0},{0,1,1,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		s.solution(n, computers);
	}
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(computers, visited, i);
				answer++;
			}
		}
		return answer;
	}
	public void dfs(int[][] computers, boolean[] visited, int k) {
		for (int i = 0; i < computers.length; i++) {
			if (i != k && !visited[i] && computers[k][i] == 1) {
				visited[i] = true;
				dfs(computers, visited, i);
			}
		}
	}
}
