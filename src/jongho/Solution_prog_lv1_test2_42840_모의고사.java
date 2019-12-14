package jongho;

import java.util.*;

public class Solution_prog_lv1_test2_42840_모의고사 {
	public static void main(String[] args) {
		int[] s = new int[] { 1,2,3,4,5,1,2,3,4,5,1,2,3,4,5 };
		System.out.println(Arrays.toString(solution(s)));
	}

    public static int[] solution(int[] answers) {
        int[][] supo = new int[][]{{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int[] cor=new int[3];
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<supo.length; j++){
                int tempi=i;
                if(tempi>=supo[j].length) tempi=tempi%supo[j].length;
                if(supo[j][tempi]==answers[i]) cor[j]++;
            }
        }
        int max=Math.max(cor[0],Math.max(cor[1],cor[2]));
        boolean[] ch = new boolean[supo.length];
        int cnt=0;
        for(int i=0; i<supo.length; i++){
            if(max==cor[i]) {cnt++; ch[i]=true;}
        }
        int[] answer=new int[cnt];
        for(int i=0, j=0; i<supo.length; i++){
            if(ch[i]==true) answer[j++]=i+1;
        }
        return answer;
    }
}
