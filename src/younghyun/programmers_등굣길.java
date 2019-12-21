package younghyun;
public class programmers_등굣길 {
    public static void main(String[] args) {
    	programmers_등굣길 a = new programmers_등굣길();
    	System.out.println(a.solution(100, 100,new int[][] {{2,2}}));
    }
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m][n];
        for(int i =0; i<puddles.length; i++){
            map[puddles[i][0]-1][puddles[i][1]-1] = -1;
        }
        map[0][0] = 1;
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == -1) continue;
				if(i>0 && map[i-1][j] !=-1) {
                    map[i][j] += map[i-1][j];
                    map[i][j] %= 1000000007;
                }
				if(j>0 && map[i][j-1] !=-1) {
                    map[i][j] += map[i][j-1];
                    map[i][j] %= 1000000007;
                }
			}
		}
        return map[m-1][n-1];
    }
}
