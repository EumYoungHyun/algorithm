package younghyun;

import java.util.Arrays;

/**
 * 섬은 양방향 연결 -> 프림 or 크루스칼 사용
 * 	크루스칼 구현 :
 *	Disjoint Set
 *
 */
public class programmers_섬연결하기_크루스칼 {
	private static int[] p;
	private static int[] rank;
	public static void main(String[] args) {
		int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}}; 
		System.out.println(solution(4, costs));
	}
	public static class Edge implements Comparable<Edge>{
		public int x;
		public int y;
		public int val;
		
		public Edge(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(Edge o) {
			return this.val - o.val;
		}

		@Override
		public String toString() {
			return "Edge [x=" + x + ", y=" + y + ", val=" + val + "]\n";
		}
		
	}
	
	public static int solution(int n, int[][] costs) {
		rank = new int[n];
		p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}
		int answer = 0;	
		Edge[] list = new Edge[costs.length];
		for (int i = 0; i < costs.length; i++) {
			list[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
		}
		Arrays.sort(list);
		int cnt = 0;
		for (int i = 0; i < list.length; i++) {
			int nx = find(list[i].x);
			int ny = find(list[i].y);
			int nval = list[i].val;
			
			if(p[nx] != p[ny]) { //연결되지 않았다면
				union(nx, ny);
				answer += nval;
				cnt++;
				if(cnt >= costs.length-1) break;
			}
			
		}
		
        return answer;
    }
	public static void union(int x, int y) {
		int nx = find(x);
		int ny = find(y);
		if(nx != ny) {
			if(rank[nx]> rank[ny]) {
				p[ny] = nx; 
			}else {
				p[nx] = ny;
				if(rank[nx] == rank[ny]) {
					rank[ny]++;
				}
			}
		}
	}
	public static int find(int x) {
		if(p[x] != x) {
			p[x] = find(p[x]);
			return p[x];
		}
		return x;
	}
}
