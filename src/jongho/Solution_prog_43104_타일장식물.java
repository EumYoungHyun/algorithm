package jongho;
import java.util.*;

//DP
public class Solution_prog_43104_타일장식물 {
	public static void main(String[] args) {
		System.out.println(solution(5));
	}
    public static long solution(int N) {
        long answer = 0;
        long[] len = new long[N];
        len[0]=1; len[1]=1;
        for(int i=2; i<N; i++){
            len[i]=len[i-1]+len[i-2];
        }
        answer=len[N-1]*4+len[N-2]*2;
        
        return answer;
    }
}