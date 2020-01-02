package jongho;

import java.util.*;


public class Solution_prog_60058_2020KAKAOBLIND_괄호변환 { 
	public static void main(String[] args) {
		int[][] picture = new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println(Arrays.toString(solution(6,4,picture)));
	}
    public static int[][] visit, fourth, pictures;
    public static int numberOfArea, maxSizeOfOneArea, areaSize;
  public static int[] solution(int m, int n, int[][] picture) {
      fourth=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};   // 상 우 하 좌
      numberOfArea = 0;
      maxSizeOfOneArea = 0;
      visit=new int[m][n];
      pictures = picture;
      
      for(int i=0; i<m; i++){
          for(int j=0; j<n; j++){
              if(visit[i][j]==0 && pictures[i][j]!=0){
                  numberOfArea++;
                  areaSize=0;
                findArea(i,j);
              }
          }
      }      
      
      int[] answer = new int[2];
      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;
      return answer;
  }
    public static void findArea(int x, int y){
    	areaSize++;
    	visit[x][y]=numberOfArea;
        maxSizeOfOneArea=Math.max(areaSize, maxSizeOfOneArea);
        for(int i=0; i<fourth.length; i++){
            int tempx= x+fourth[i][0];
            int tempy= y+fourth[i][1];
            if(tempx>=0 && tempy>=0 && tempx<visit.length && tempy<pictures[0].length && visit[tempx][tempy]==0 && pictures[x][y]==pictures[tempx][tempy]){
                findArea(tempx, tempy);                 
            }
        }
    }
}