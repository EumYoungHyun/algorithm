package sungchan;
import java.util.Arrays;

public class Programmers_저울 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 1, 6, 2, 7, 30, 1}));
	}
	
	public static int solution(int[] weight) {
        Arrays.sort(weight);
        int result = 1;
        
        for(int i=0; i<weight.length; i++) {
        	if(result < weight[i]) {
        		break;
        	}
        	
        	result = result + weight[i];
        }
        
        return result;
   }
}
