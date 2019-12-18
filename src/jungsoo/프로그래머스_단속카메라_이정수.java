package jungsoo;

import java.util.*;

public class 프로그래머스_단속카메라_이정수 {
	public int solution(int[][] routes) {
        int answer = 0;
        boolean visited[]=new boolean[routes.length];
        Arrays.sort(routes,new Comparator<int[]>() {
            public int compare(int [] o1, int[] o2){
                if(o1[0]==o2[0])
                    return o1[1]-o2[1];
                return o1[1]-o2[1];
            }
        });
        for(int i=0;i<routes.length;i++){
            if(!visited[i]){
                for(int j=i+1;j<routes.length;j++){
                    if(!visited[j] && routes[j][0]<=routes[i][1]){
                        visited[j]=true;
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}