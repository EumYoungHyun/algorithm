package jongho;
import java.util.*;

//Stack
public class Solution_prog_42584_주식가격 {
	public static void main(String[] args) {
		int[] prices = new int[] {1,2,3,2,3};
		System.out.println(Arrays.toString(solution(prices)));
	}
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < answer.length; i++) {
            for (int j = i+1; j < answer.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j-i;
                    break;
                }
                if (j==answer.length-1) answer[i] = j-i;
            }
        }
        return answer;
    }
}