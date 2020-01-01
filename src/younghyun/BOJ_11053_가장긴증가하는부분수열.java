package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] list = new int[N];
		int[] memo = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
			int temp = 0;
			for (int j = 0; j < i; j++) {
				if(list[i]>list[j]) {
					if(temp < memo[j]) temp = memo[j];
				}
			}
			memo[i] = temp +1;
			if(max < memo[i]) max = memo[i];
		}
		System.out.println(max);
	}
	
}
