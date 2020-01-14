package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9095_1_2_3_더하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[11];
		memo[1] = 1;
		memo[2] = 2;
		memo[3] = 4;
		for (int i = 4; i <= 10; i++) {
			memo[i] = memo[i-1]+memo[i-2]+memo[i-3];
		}
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			System.out.println(memo[x]);
		}
	}
}
