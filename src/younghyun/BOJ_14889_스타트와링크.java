package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {
	private static int[] arr;
	private static int min = Integer.MAX_VALUE;
	private static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arr = new int[N/2];
		// 1) comb로 맴버 N/2명의 조합 만들기
		comb(N, N/2);
		System.out.println(min);
	}// end of main
	public static void comb(int n, int r) {
		if(r == 0) {
			boolean[] brr = new boolean[arr.length*2];
			for (int i = 0; i < arr.length; i++) {
				brr[arr[i]] = true;
			}
//			System.out.println(Arrays.toString(brr));
			int teamA = 0;
			for (int i = 0; i < brr.length; i++) {
				if(brr[i]) continue; 
				for (int j = 0; j < brr.length; j++) {
					if(brr[j]) continue;
					teamA += map[i][j];
				}
			}
			int teamB = 0;
			for (int i = 0; i < brr.length; i++) {
				if(!brr[i]) continue; 
				for (int j = 0; j < brr.length; j++) {
					if(!brr[j]) continue;
					teamB += map[i][j];
				}
			}
//			System.out.println(teamA + " " + teamB);
			teamA -= teamB;
			if(teamA <0) teamA*=-1;
			if(min>teamA) min = teamA;
			return;
		}
		if(n<r || min == 0) return;
		arr[r-1] = n-1;
		comb(n-1, r-1);
		comb(n-1, r);
	}
}
