package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987_월드컵 {
	private static boolean[] result;
	private static int[][] resultmap;
	private static String[] insetresult;

	public static void main(String[] args) throws Exception {
		// dfs
		// 3가지 다 확인하면서  2차원 배열에 결과값 저장
		// 들어온 입력값 확인
		// 4가지 확인해서 boolean 배열에 결과 저장
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result = new boolean[4];
		insetresult = new String[4];
		for (int i = 0; i < 4; i++) {
			insetresult[i] = br.readLine();
		}
		resultmap = new int[6][3];
		dfs(0, 0);
		for (int i = 0; i < 4; i++) {
			if(result[i]) System.out.print(1+" ");
			else System.out.print(0+" ");
		}
	}
	public static void dfs(int A, int B) {
		if(A>=6 || B>=6 || (A!=0 && A!=5 && A==B)) return;
		if(A==5 && B==5) {
			for (int i = 0; i < 4; i++) {
				if(result[i]) continue;
				result[i] = true;
				StringTokenizer st = new StringTokenizer(insetresult[i]);
				for (int j = 0; j < 6; j++) {
					for (int k = 0; k < 3; k++) {
						if(resultmap[j][k] != Integer.parseInt(st.nextToken())) {
							result[i] = false;
							break;
						}
					}
				}
			}
			return;
		}
				resultmap[A][0]+=1;
				resultmap[B][2]+=1;
				dfs(A, B+1);
				dfs(A+1, B);
				resultmap[A][0]-=1;
				resultmap[B][2]-=1;
				
				resultmap[A][1]+=1;
				resultmap[B][1]+=1;
				dfs(A, B+1);
				dfs(A+1, B);
				resultmap[A][1]-=1;
				resultmap[B][1]-=1;
				
				resultmap[A][2]+=1;
				resultmap[B][0]+=1;
				dfs(A, B+1);
				dfs(A+1, B);
				resultmap[A][2]-=1;
				resultmap[B][0]-=1;
	}
}
