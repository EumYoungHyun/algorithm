package jongho;
import java.util.*;

public class Solution_prog_42842_카펫 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10,2)));
	}
    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int i;
        for(i=3; i*i<=brown+red; i++){
            if((2*i-(Math.pow(i,2)-brown/2*i))==(brown+red)){
                answer[1]=i;
                answer[0]=(brown+red)/i;
                break;
            }
        }
        return answer;
    }
}
