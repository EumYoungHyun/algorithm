package sungchan;

public class Programmers_타겟넘버 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,1,1,1,1}, 3));
	}
	
	static int count;
    public static int solution(int[] numbers, int target) {
        count = 0;
        solve(numbers, target, 0, 0);
        
        return count;
    }
    
    public static void solve(int numbers[], int target, int index, int sum) {
        if(index >= numbers.length) {
            if(sum == target) {
                count++;
            }
            return;
        }
        
        solve(numbers, target, index+1, sum+numbers[index]);
        solve(numbers, target, index+1, sum-numbers[index]);
    }
}
