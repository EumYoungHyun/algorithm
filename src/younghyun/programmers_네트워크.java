package younghyun;

public class programmers_네트워크 {
	private static int[] p;
	private static int[] rank;
	public static void main(String[] args) {
		int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};
		System.out.println(solution(3, computers));
	}
	public static int solution(int n, int[][] computers) {
		rank = new int[n];
		p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}
		for (int i = 0; i < computers.length; i++) {
			for (int j = i+1; j < computers.length; j++) {
				if(computers[i][j] == 1) union(i, j);
			}
		}
		int answer = 0;
		boolean[] check = new boolean[computers.length];
		for (int i = 0; i < rank.length; i++) {
			find(i);
			if(!check[p[i]]) {
				answer++;
				check[p[i]] = true;
			}
		}
        return answer;
    }
	public static void union(int n1, int n2) {
		if(rank[n1] > rank[n2]) {
			p[n2] = p[n1];
		}
		else {
			p[n1] = p[n2];
			if(rank[n1] == rank[n2]) rank[n2]++;
		}
		
	}
	public static int find(int n) {
		if(n == p[n]) {
			return n;
		}
		p[n] = find(p[n]);
		return p[n];
	}
}
