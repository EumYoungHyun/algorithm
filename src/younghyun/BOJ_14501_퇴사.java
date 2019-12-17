package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] date = new int[N+1][2];
		int[] memo = new int[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			date[i][0] = Integer.parseInt(st.nextToken());
			date[i][1] = Integer.parseInt(st.nextToken());
			memo[i] =date[i][1];
		}
	    for (int i = 2; i <= N; i++) {
	        for (int j = 1; j < i; j++) {
	            if (i - j >= date[j][0]) {
	                memo[i] = Math.max(date[i][1] + memo[j], memo[i]);
	            }
	        }
	    }
	    int max = 0;
	    
	    for (int i = 1; i <= N; i++) {
	        if (i + date[i][0] <= N +1) {
	            if (max < memo[i]) {
	                max = memo[i];
	            }
	        }
	    }
		System.out.println(max);
	}
}