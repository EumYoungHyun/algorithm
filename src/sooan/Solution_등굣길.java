package sooan;

public class Solution_등굣길 {
	public static void main(String[] args) {
		Solution_등굣길 s = new Solution_등굣길();
		int m = 4, n=3;
		int[][] puddles = {{2,2}};
		System.out.println(s.solution(m, n, puddles));
	}
	public int solution(int m, int n, int[][] puddles) {
        int P = 1000000007;
        int[][] memo = new int[n+1][m+1];
        for(int i=0; i<puddles.length; i++){
            memo[puddles[i][1]][puddles[i][0]] = -1;
        }
        memo[1][1] = 1;
        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
            	if(i==1 && j==1) continue;
                if(memo[i][j] == -1){
                    memo[i][j] = 0;
                    continue;
                }
                memo[i][j] = (memo[i][j-1] + memo[i-1][j]) % P;
            }
        }
        return memo[n][m];
    }
}
