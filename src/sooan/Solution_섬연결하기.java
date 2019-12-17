package sooan;

import java.util.Arrays;

public class Solution_섬연결하기 {
	public static void main(String[] args) {
		Solution_섬연결하기 s = new Solution_섬연결하기();
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(s.solution(n, costs));
	}
	class Edge implements Comparable<Edge>{
		int a;
		int b;
		int val; //가중치
		public Edge(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}
		@Override
		public int compareTo(Edge o) {
			return this.val - o.val;
		}
	}

	private int[] p;
	private int[] rank;
	
    public int solution(int n, int[][] costs) {
        int answer = 0;
        //n : 정점의 개수 cost.length : 간선의 갯수
        Edge[] G = new Edge[costs.length]; //간선 저장할 배열
        for (int i = 0; i < G.length; i++) {
			G[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);//정점1,정점2,가중치
		}
        Arrays.sort(G); //가중치가 작은 순으로 정렬
        
        p = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
			makeSet(i);
		}
        int cnt = 0; //카운트 할 간선의 갯수 -> cost.length-1이면 break;
        for (int i = 0; i < G.length; i++) {
        	//작은 가중치 부터 꺼내기
        	Edge e = G[i];
        	//부모 찾기
        	int px = findSet(e.a);
        	int py = findSet(e.b);
        	//합치기
        	if(px!=py) {
        		union(px,py);
        		answer += e.val;
        		cnt++;
        		if(cnt == n-1) {
        			break;
        		}
        	}
        }
        return answer;
    }

	private void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(px!=py) {
			//rank값을 기준으로 작은 쪽을 큰 쪽에 붙이기
			if(rank[px] > rank[py]) {
				p[py] = px;
			}else {
				p[px] = py;
				if(rank[px]==rank[py]) {
					rank[py]++;
				}
			}
		}
	}

	private int findSet(int x) {
		if(p[x] == x) {
			return x;
		}else {
			p[x] = findSet(p[x]); //path compression
			return p[x];
		}
	}

	private void makeSet(int i) {
		p[i] = i;
		rank[i] = 0; //초기값
	}
}
