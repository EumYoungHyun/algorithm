package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] memo = new int[N][3];
		memo[0][0] = cost[0][0];
		memo[0][1] = cost[0][1];
		memo[0][2] = cost[0][2];
		for (int i = 1; i < memo.length; i++) {
			memo[i][0] = memo[i-1][1] + cost[i][0];
			if(memo[i][0] > memo[i-1][2] + cost[i][0])
				memo[i][0] = memo[i-1][2] + cost[i][0];
			memo[i][1] = memo[i-1][0] + cost[i][1];
			if(memo[i][1] > memo[i-1][2] + cost[i][1])
				memo[i][1] = memo[i-1][2] + cost[i][1];
			memo[i][2] = memo[i-1][1] + cost[i][2];
			if(memo[i][2] > memo[i-1][0] + cost[i][2])
				memo[i][2] = memo[i-1][0] + cost[i][2];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if(min > memo[N-1][i]) min = memo[N-1][i];
		}
		System.out.println(min);
	}
}
