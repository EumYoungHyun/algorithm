package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15650_N과M_2 {
	private static int[] arr;
	private static int n, R;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		n = str.charAt(0)-'0';
		R = str.charAt(2)-'0';
		arr = new int[R];
		comb(0, 0);
		System.out.println(sb);
	}
	public static void comb(int c, int r) {
		if(c == R) {
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = r; i < n; i++) {
			arr[c] = i+1;
			comb(c+1, i+1);
		}
	}
}
