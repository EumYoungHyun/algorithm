package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15649_N과M_1 {
	private static int[] arr;
	private static boolean[] check;
	private static int[] brr;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = str.charAt(0)-'0';
		int r = str.charAt(2)-'0';
		arr = new int[n];
		check = new boolean[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		brr = new int[r];

		permutation(r, 0);
		System.out.println(sb);
	}
	public static void permutation(int r, int cnt) {
		if(r<=0) {
			for (int i = 0; i < brr.length; i++) {
				sb.append(brr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(check[i]) continue;
			check[i] = true;
			brr[cnt] = arr[i];
			permutation(r-1, cnt+1);
			check[i] = false;
		}
	}
}
