package jongho;
import java.util.*;

//DP
public class Solution_prog_42898_등굣길 {
	public static void main(String[] args) {
		int[][] puddles = new int[][] {{2,2}};
		System.out.println(solution(4,3,puddles));
	}
    public static int[][] road;
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        road = new int[n+1][m+1];
        for(int i=0; i<puddles.length; i++){
            road[puddles[i][1]][puddles[i][0]]=-1;
        }
        road[1][1]=1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(road[i][j]==-1) road[i][j]=0;
                else if(i==1) road[i][j]+=road[i][j-1];
                else road[i][j]=(road[i-1][j]+road[i][j-1])%1000000007;
            }
        }
        answer=road[n][m]%1000000007;
        return answer;
    }
}