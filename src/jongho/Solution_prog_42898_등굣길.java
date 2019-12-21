package jongho;
import java.util.*;

//DP
public class Solution_prog_42898_등굣길 {
    public static int[][] road;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        road = new int[n][m];
        for(int i=0; i<puddles.length; i++){
            road[puddles[i][1]-1][puddles[i][0]-1]=-1;
        }
        road[0][0]=1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(road[i][j]==-1) road[i][j]=0;
                else if(j==0) road[i][j]=1;
                else if(i==0) road[i][j]=(road[i][j]+road[i][j-1])%1000000007;
                else road[i][j]=(road[i-1][j]+road[i][j-1])%1000000007;
            }
        }
        answer=road[n-1][m-1]%1000000007;
        return answer;
    }
}