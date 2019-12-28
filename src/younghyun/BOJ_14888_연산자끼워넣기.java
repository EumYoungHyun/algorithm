package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {
	private static int N, max= Integer.MIN_VALUE, min= Integer.MAX_VALUE;
	private static int[] arr, oper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		oper = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		// 순열
		dfs(oper[0], oper[1], oper[2], oper[3], arr[0], 1);
		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int p, int m, int M, int d, int num, int count) {
		if (p == 0 && m == 0 && M == 0 && d == 0) {
			if(max < num) max = num;
			if(min > num) min = num;
			return;
		}
		if(p>0) dfs(p-1, m, M, d, num+arr[count], count+1);
		if(m>0) dfs(p, m-1, M, d, num-arr[count], count+1);
		if(M>0) dfs(p, m, M-1, d, num*arr[count], count+1);
		if(d>0) dfs(p, m, M, d-1, num/arr[count], count+1);
		
	}
}
