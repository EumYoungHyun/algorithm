package jungsoo;

public class 프로그래머스_정수삼각형_이정수 {
	public int solution(int[][] triangle) {
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j==0){
                    triangle[i][0]+=triangle[i-1][0];
                }
                else if(j==triangle[i].length-1){
                    triangle[i][j]+=triangle[i-1][j-1];
                } else{
                    triangle[i][j]=Math.max(triangle[i-1][j-1],triangle[i-1][j])+triangle[i][j];
                }
            }
        }
        int max=triangle[triangle.length-1][0];
        for(int i=1;i<triangle[triangle.length-1].length;i++){
            max=Math.max(max,triangle[triangle.length-1][i]);
        }
        return max;
    }
}