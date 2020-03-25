package sungchan;

public class Programmers_보행자천국 {
	public static void main(String[] args) {
		System.out.println(solution(3, 3, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
		System.out.println(solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
	}

	static int MOD = 20170805;
	
	public static int solution(int m, int n, int[][] cityMap) {
		int right[][] = new int[m+1][n+1];
        int down[][] = new int[m+1][n+1];
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(i==1 && j==1) {
                    right[i][j] = down[i][j] = 1;
                } else {
                    switch(cityMap[i-1][j-1]) {
                    case 0:
                        down[i][j] = right[i][j] = (right[i][j-1] + down[i-1][j])%MOD;
                        break;
                        
                    case 1:
                        break;
                        
                    case 2:
                        right[i][j] = right[i][j-1];
                        down[i][j] = down[i-1][j];
                        break;
                    }
                }
            }
        }
        
        return right[m][n];
    }
}
