package younghyun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1765_닭싸움팀정하기 {
	static int n, m;
	static List<Integer>[] map;
	static int[] d;
	static int cnt;
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		map = new List[n+1];
		d = new int[n+1];
		Arrays.fill(d, -1);
		
		for (int i = 1; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char alliance = st.nextToken().charAt(0);
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			// E, F 판별
			if (alliance == 'E') {
				map[s].add(-1 *e);
				map[e].add(-1 *s);
			} else {
				map[s].add(e);
				map[e].add(s);
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if(d[i] == -1)
				d[i] = cnt++;
			cnt += dfs(cnt + 1, i);
			bfs(i);
		}
		System.out.println(cnt);
	}

	static int dfs(int prev, int x) {
		int f = 0;
		for(int i = 0; i < map[x].size(); i++) {
			if (map[x].get(i) < 0 && d[-1*map[x].get(i)] == -1) {
				f = 1;
				d[-map[x].get(i)] = prev;
				dfs(d[x], -map[x].get(i));
			}
		}
		return f;
	}
	
	static void bfs(int node) {
		Deque<Integer> q = new LinkedList<Integer>();
		q.push(node);
		
		while(!q.isEmpty()) {
			int value = q.pollFirst();
			
			for (int i = 0; i < map[value].size(); i++) {
				if (map[value].get(i) > 0 && d[map[value].get(i)] == -1) {
					d[map[value].get(i)] = d[value];
					q.push(map[value].get(i));
				}
			}
		}
	}
}
