package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15684_사다리조작 {
	private static int[][] map;
	private static int min = Integer.MAX_VALUE;
	private static int lineNum = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int colCount  = Integer.parseInt(st.nextToken());
		int lineCount = Integer.parseInt(st.nextToken());
		int rowCount  = Integer.parseInt(st.nextToken());
	
		map = new int[rowCount+1][colCount+1];
		for (int i = 0; i < lineCount; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int lineRow = Integer.parseInt(st.nextToken());
			int lineCol = Integer.parseInt(st.nextToken());
			map[lineRow][lineCol]   = lineNum++;
			map[lineRow][lineCol+1] = lineNum++;
		}
		
		routeMaker(1, 1, 0);
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}// end of main
	public static void routeMaker(int row, int col, int lineMakeCount) {
		for (int[] bs : map) {
			System.out.println(Arrays.toString(bs));
		}
		System.out.println();
		if(col == map[0].length) return;
		if(lineMakeCount >= 4 || lineMakeCount > min) return;
		if(row == map.length) {
			for (int i = 1; i < map[0].length; i++) {
				int arrival = routeNavigation(i);
				if(i != arrival) return;
			}
			if(min > lineMakeCount) {
				min = lineMakeCount;
			}
			return;
		}
		routeMaker(row+1, col, lineMakeCount);
		routeMaker(row, col+1, lineMakeCount);
		if(col+1 >= map[0].length || map[row][col] - map[row][col+1] != -1 ) return;
		map[row][col] = lineNum++;
		map[row][col+1] = lineNum++;
		routeMaker(row+1, col, lineMakeCount+1);
		routeMaker(row, col+1, lineMakeCount+1);
		map[row][col] = 0;
		map[row][col+1] = 0;
	}
	public static int routeNavigation(int colLocation) {

	}
}// end of class
