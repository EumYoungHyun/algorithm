package sungchan;
import java.util.Arrays;

public class Programmers_카펫 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));
		System.out.println(Arrays.toString(solution(8, 1)));
		System.out.println(Arrays.toString(solution(24, 24)));
	}
	
	public static int[] solution(int brown, int red) {
        int result[] = new int[2];
        
        for(int i=1; i<=Math.sqrt(red); i++) {
            if(red%i == 0) {
                int col = i;
                int row = red/i;
                
                if(brown == (col*2 + row*2 + 4)) {
                    result[0] = row+2;
                    result[1] = col+2;
                    break;
                }
            }
        }
        
        return result;
    }
}
