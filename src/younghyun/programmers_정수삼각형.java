package younghyun;


class programmers_정수삼각형 {
	public static void main(String[] args) {
		programmers_정수삼각형 s = new programmers_정수삼각형();
		System.out.println(s.solution(new int[][] {{1}, {2,3}, {4,5,6}, {1, 1, 1, 1}}));
	}
	public int solution(int[][] triangle) {
        int answer = 0;
        int[][] memo = new int[triangle.length][];
        memo[0] = new int[1];
        memo[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; i++){
        	memo[i] = new int[i+1];
            memo[i][0] = memo[i-1][0] +triangle[i][0];
            memo[i][1] = memo[i-1][0] +triangle[i][1];
            memo[i][triangle[i].length-1] = memo[i-1][triangle[i-1].length-1] + triangle[i][triangle[i].length-1];
            if(memo[i][triangle[i].length-2] < memo[i-1][triangle[i-1].length-1] + triangle[i][triangle[i].length-2])
            	memo[i][triangle[i].length-2] = memo[i-1][triangle[i-1].length-1] + triangle[i][triangle[i].length-2];
        }
        for(int i = 1; i < triangle.length -1 ; i++){
            for(int j = 1; j < triangle[i].length-1; j++){
                if(memo[i+1][j] < memo[i][j] + triangle[i+1][j]){
                    memo[i+1][j] = memo[i][j] + triangle[i+1][j];
                }
                if(memo[i+1][j+1] < memo[i][j] + triangle[i+1][j+1]){
                    memo[i+1][j+1] = memo[i][j] + triangle[i+1][j+1];
                }
            }
        }
        int max = triangle[triangle.length-1][0];
        for (int i = 0; i < triangle.length; i++) {
        	if(max < memo[triangle.length-1][i]) {
        		max = memo[triangle.length-1][i];
        	}
        }
        return max;
    }
}