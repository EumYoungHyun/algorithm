package jongho;
import java.util.*;

//Stack
public class Solution_prog_42886_저울 {
	public static void main(String[] args) {
		int[] weights = new int[] {3, 1, 6, 2, 7, 30, 1};
		System.out.println((solution(weights)));
	}
	public static int solution(int[] weights) {
        int answer = 0;
        Arrays.sort(weights);
        answer=weights[0];

        for (int i = 1; i < weights.length; i++) {
            if (answer+1 < weights[i]) break;
            else answer += weights[i];
        }
    
        return answer+1;
    }
}