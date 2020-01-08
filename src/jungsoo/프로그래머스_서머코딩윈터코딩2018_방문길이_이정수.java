package jungsoo;

public class 프로그래머스_서머코딩윈터코딩2018_방문길이_이정수 {
	public int solution(String dirs) {
		int answer = 0;
		int check[][][][] = new int[11][11][11][11];
		int x = 5;
		int y = 5;
		for (int i = 0; i < dirs.length(); i++) {
			char temp = dirs.charAt(i);
			if (temp == 'U') {
				if (y < 10) {
					if (check[x][y][x][y + 1] == 0) {
						answer++;
						check[x][y][x][y + 1] = 1;
						check[x][y + 1][x][y] = 1;
					}
					y++;
				}
			} else if (temp == 'D') {
				if (y > 0) {
					if (check[x][y][x][y - 1] == 0) {
						answer++;
						check[x][y][x][y - 1] = 1;
						check[x][y - 1][x][y] = 1;
					}
					y--;
				}
			} else if (temp == 'L') {
				if (x > 0) {
					if (check[x][y][x - 1][y] == 0) {
						answer++;
						check[x][y][x - 1][y] = 1;
						check[x - 1][y][x][y] = 1;
					}
					x--;
				}
			} else {
				if (x < 10) {
					if (check[x][y][x + 1][y] == 0) {
						answer++;
						check[x][y][x + 1][y] = 1;
						check[x + 1][y][x][y] = 1;
					}
					x++;
				}
			}
		}
		return answer;
	}
}