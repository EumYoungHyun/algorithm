package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500_테트로미노 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 누운 직선
				if(j + 3 < M) {
					if(max < map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3]) {
						max = map[i][j] + map[i][j+1] + map[i][j+2] + map[i][j+3];
					}
				}
				// 선직선
				if(i+3 < N) {
					if(max < map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j]) {
						max = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+3][j];
					}
				}
				// 네모
				if(i+1 < N && j+1 < M) {
					if(max < map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1]) {
						max = map[i][j] + map[i+1][j] + map[i][j+1] + map[i+1][j+1];
					}
				}
				// ㅓ
				if(i+2 < N && j+1 < M) {
					if(max < map[i+1][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1]) {
						max = map[i+1][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
					}
				}
				// ㅜ
				if(i+1 < N && j+2 < M) {
					if(max < map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1]) {
						max = map[i][j] + map[i][j+1] + map[i][j+2] + map[i+1][j+1];
					}
				}
				// ㅏ
				if(i+2 < N && j+1 < M) {
					if(max < map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1]) {
						max = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
					}
				}
				// ㅗ
				if(i+1 < N && j+2 < M) {
					if(max < map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2]) {
						max = map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+1][j+2];
					}
				}
				// ㄴ 
				if(i+2 < N && j+1 < M) {
					if(max < map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1]) {
						max = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+2][j+1];
					}
				}
				// ㄴ 대칭
				if(i+2 < N && j+1 < M) {
					if(max < map[i][j+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+2][j]) {
						max = map[i][+1] + map[i+1][j+1] + map[i+2][j+1] + map[i+2][j];
					}
				}
				// ㄴ 회전
				if(i+1 < N && j+2 < M) {
					if(max < map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+2]) {
						max = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+2];
					}
				}
				if(i+2 < N && j+1 < M) {
					if(max < map[i+2][j] + map[i+1][j+1] + map[i+2][j+1] + map[i][j+1]) {
						max = map[i+2][j] + map[i+1][j+1] + map[i+2][j+1] + map[i][j+1];
					}
				}
				// ㄴ 회전 대칭
				if(i+1 < N && j+2 < M) {
					if(max < map[i][j] + map[i+1][j+1] + map[i+1][j+2] + map[i+1][j]) {
						max = map[i][j] + map[i+1][j+1] + map[i+1][j+2] + map[i+1][j];
					}
				}
				// ㄱ
				if(i+2 < N && j+1 < M) {
					if(max < map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1]) {
						max = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i+2][j+1];
					}
				}
				// ㄱ 대칭
				if(i+2 < N && j+1 < M) {
					if(max < map[i][j] + map[i+1][j] + map[i+2][j] + map[i][j+1]) {
						max = map[i][j] + map[i+1][j] + map[i+2][j] + map[i][j+1];
					}
				}
				// ㄱ 회전
				if(i+1 < N && j+2 < M) {
					if(max < map[i][j] + map[i+1][j] + map[i][j+1] + map[i][j+2]) {
						max = map[i][j] + map[i+1][j] + map[i][j+1] + map[i][j+2];
					}
				}
				// ㄱ 회전 대칭
				if(i+1 < N && j+2 < M) {
					if(max < map[i][j] + map[i+1][j+2] + map[i][j+1] + map[i][j+2]) {
						max = map[i][j] + map[i+1][j+2] + map[i][j+1] + map[i][j+2];
					}
				}
				// 번개
				if(i+2 < N && j+1 < M) {
					if(max < map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1]) {
						max = map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j+1];
					}
				}
				// 번개 회전
				if(i+2 < N && j+1 < M) {
					if(max < map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j]) {
						max = map[i][j+1] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
					}
				}
				// 누운번개
				if(i+1 < N && j+2 < M) {
					if(max < map[i+1][j] + map[i+1][j+1] + map[i][j+1] + map[i][j+2]) {
						max = map[i+1][j] + map[i+1][j+1] + map[i][j+1] + map[i][j+2];
					}	
				}
				// 누운번개 회전
				if(i+1 < N && j+2 < M) {
					if(max < map[i][j] + map[i+1][j+1] + map[i][j+1] + map[i+1][j+2]) {
						max = map[i][j] + map[i+1][j+1] + map[i][j+1] + map[i+1][j+2];
					}	
				}
			}
		}// end of for
		System.out.println(max);
		
	}
}
