package sooan;

public class Solution_타겟넘버 {
	public static void main(String[] args) {
		Solution_타겟넘버 s = new Solution_타겟넘버();
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		s.solution(numbers, target);
	}
	public int cnt = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,0,target,0);
        return cnt;
    }
    public void dfs(int[] numbers,int k,int target,int sum){
        if(k==numbers.length){
            if(sum==target)
                cnt++;
        }else{
            dfs(numbers,k+1,target,sum+numbers[k]);
            dfs(numbers,k+1,target,sum-numbers[k]);
        }
    }
}
