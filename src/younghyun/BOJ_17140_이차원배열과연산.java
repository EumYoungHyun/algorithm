package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17140_이차원배열과연산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int val = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[101][101];
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		boolean flag = true;
		for (answer = 0; answer < 100; answer++) {
			if(flag) { // R 연산 행개수 >= 열개수
				
			}else {	// C 연산  행개수 < 열개수
				
			}
			
		}// end of for(answer)
		if(answer == 100) System.out.println(answer);
		else System.out.println(answer);
	}
}	
