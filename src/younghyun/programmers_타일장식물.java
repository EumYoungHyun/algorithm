package younghyun;

class programmers_타일장식물 {
    public long solution(int N) {
        long[] memo = new long[81];
        memo[1] = 4;
        memo[2] = 6;
        for(int i = 3; i<memo.length; i++){
            memo[i] = memo[i-1]+memo[i-2];
        }
        return memo[N];
    }
}