package sooan;

public class Solution_타일장식물 {
	public long solution(int N) {
        long[] memo = new long[N];
        memo[0] = 1;
        memo[1] = 1;
        for(int i=2; i<N; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        if(N==1) return 6;
        return memo[N-1]*4 + memo[N-2]*2;
    }
}
