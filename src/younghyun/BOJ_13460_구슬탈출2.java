package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13460_구슬탈출2 {
	private static int min= Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str= br.readLine();
			map[i] = str.toCharArray();
		}
		char[][] temp = new char[N][M];
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < N; i++) {
				temp[i] = map[i].clone();
			}			
			BruteForse(temp, 1, j);
		}
		if(min != Integer.MAX_VALUE)
			System.out.println(min);
		else 
			System.out.println(-1);
	}
	public static void BruteForse(char[][] map, int count, int dir) {
		if(count > 10 || min<=count) return;
		char[][] temp2 = move(map, dir);
		char[][] temp = new char[temp2.length][temp2[0].length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = temp2[i].clone();
		}
		//임의로 맵을 수정하여 파란공이 골에 들어가면 0,1을 X로 변경하고
		if(temp[0][1] == 'X') return;
		//빨간공이 골에 들어가면 0,0 을 X로 변경.
		if(temp[0][0] == 'X') {
			min = count;
			return;
		}
		if(min == 9) {
			for (char[] cs : temp) {
				System.out.println(Arrays.toString(cs));
			}
			System.out.println();
		}
		
		for (int i = 0; i < 4; i++) {
			if(dir == i) continue;
			BruteForse(temp, count+1, i);
		}
	}
	public static char[][] move(char[][] temp, int dir) {
		int[] r = new int[2];
		int[] b = new int[2];
		char[][] map = new char[temp.length][temp[0].length];
		for (int i = 0; i < map.length; i++) {
			map[i] = temp[i].clone();
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 'B') {
					b[0] = i;
					b[1] = j;
					map[i][j] = '.';
				}
				if(map[i][j] == 'R') {
					r[0] = i;
					r[1] = j;
					map[i][j] = '.';
				}
			}
		}
		
		/**
		 *  0:상 ,   1:하,    2:좌,    3:우 
		 */
		char c = 'r';
		switch (dir) {	
		//상
		case 0:
			if(b[0] < r[0]) c = 'b';
			while(true) {
				if(b[0]-1 < 0 || map[b[0]-1][b[1]] == '#') break;
				if(map[b[0]-1][b[1]]== 'O') {
					map[0][1] = 'X';
					break;
				}
				b[0]--;
			}
			while(true) {
				if(r[0]-1 < 0 || map[r[0]-1][r[1]] == '#') break;
				if(map[r[0]-1][r[1]]== 'O') {
					map[0][0] = 'X';
					break;
				}
				r[0]--;
			}
			if(b[0] == r[0] && b[1] == r[1]) {
				if(c == 'b') {
					map[r[0]+1][r[1]] = 'R';
					map[b[0]][b[1]] = 'B';
				}else {
					map[r[0]][r[1]] = 'R';
					map[b[0]+1][b[1]] = 'B';
				}
			}else {
				map[r[0]][r[1]] = 'R';
				map[b[0]][b[1]] = 'B';
			}
			
			break;
		//하
		case 1:
			if(b[0] < r[0]) c = 'b';
			while(true) {
				if(b[0]+1 >= map.length-1 || map[b[0]+1][b[1]] == '#') break;
				if(map[b[0]+1][b[1]]== 'O') {
					map[0][1] = 'X';
					break;
				}
				b[0]++;
			}
			while(true) {
				if(r[0]+1 >= map.length-1 || map[r[0]+1][r[1]] == '#') break;
				if(map[r[0]+1][r[1]]== 'O') {
					map[0][0] = 'X';
					break;
				}
				r[0]++;
			}
			if(b[0] == r[0] && b[1] == r[1]) {
				if(c == 'b') {
					map[r[0]][r[1]] = 'R';
					map[b[0]-1][b[1]] = 'B';
				}else {
					map[r[0]-1][r[1]] = 'R';
					map[b[0]][b[1]] = 'B';
				}
			}else {
				map[r[0]][r[1]] = 'R';
				map[b[0]][b[1]] = 'B';
			}
			break;
		//좌
		case 2:
			if(b[1] < r[1]) c = 'b';
			while(true) {
				if(b[1]-1 < 0 || map[b[0]][b[1]-1] == '#') break;
				if(map[b[0]][b[1]-1]== 'O') {
					map[0][1] = 'X';
					break;
				}
				b[1]--;
			}
			while(true) {
				if(r[1]-1 < 0 || map[r[0]][r[1]-1] == '#') break;
				if(map[r[0]][r[1]-1]== 'O') {
					map[0][0] = 'X';
					break;
				}
				r[1]--;
			}
			if(b[0] == r[0] && b[1] == r[1]) {
				if(c == 'b') {
					map[r[0]][r[1]+1] = 'R';
					map[b[0]][b[1]] = 'B';
				}else {
					map[r[0]][r[1]] = 'R';
					map[b[0]][b[1]+1] = 'B';
				}
			}else {
				map[r[0]][r[1]] = 'R';
				map[b[0]][b[1]] = 'B';
			}
			break;
		//우
		default:
			if(b[1] < r[1]) c = 'b';
			while(true) {
				if(b[1]+1>=map[0].length-1 || map[b[0]][b[1]+1] == '#') break;
				if(map[b[0]][b[1]+1]== 'O') {
					map[0][1] = 'X';
					break;
				}
				b[1]++;
			}
			while(true) {
				if(r[1]+1>=map[0].length-1 || map[r[0]][r[1]+1] == '#') break;
				if(map[r[0]][r[1]+1]== 'O') {
					map[0][0] = 'X';
					break;
				}
				r[1]++;
			}
			if(b[0] == r[0] && b[1] == r[1]) {
				if(c == 'b') {
					map[r[0]][r[1]] = 'R';
					map[b[0]][b[1]-1] = 'B';
				}else {
					map[r[0]][r[1]-1] = 'R';
					map[b[0]][b[1]] = 'B';
				}
			}else {
				map[r[0]][r[1]] = 'R';
				map[b[0]][b[1]] = 'B';
			}
			break;
		}
		
		
		
		
		return map;
	}
}
