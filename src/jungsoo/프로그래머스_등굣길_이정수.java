package jungsoo;

public class 프로그래머스_등굣길_이정수 {
	 public int solution(int m, int n, int[][] puddles) {
	        int answer = 0;
	        int arr[][]=new int[n+1][m+1];
	        for(int i=0;i<puddles.length;i++){
	            arr[puddles[i][1]][puddles[i][0]]=-1;
	        }
	        arr[1][1]=1;
	        for(int i=1;i<=n;i++){
	            for(int j=1;j<=m;j++){
	                if(arr[i][j]==-1)//웅덩이면 무시
	                    continue;
	                if(i-1>0 && arr[i-1][j]!=-1) //스타트가 1,1부터 이므로 범위 체크후  위쪽이 웅덩이면 계산하지 않는다.
	                    arr[i][j]+=arr[i-1][j]%1000000007;
	                if(j-1>0 && arr[i][j-1]!=-1) //스타트가 1,1부터 이므로 범위 체크후  왼쪽이 웅덩이면 계산하지 않는다.
	                    arr[i][j]+=arr[i][j-1]%1000000007;
	            }
	        }
	        answer=arr[n][m]%1000000007;
	        return answer;
	    }
}