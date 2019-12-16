package younghyun;

/**
 * powerset 
 *
 */
public class programmers_타겟넘버 {
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1,3,1,2};
		System.out.println(solution(numbers, 3));
	}
	private static int answer;
	public static int solution(int[] numbers, int target) {
		boolean[] check = new boolean[numbers.length];
		powerset(numbers.length, 0, check, numbers, target);
		return answer;
    }
	public static void powerset(int N, int count, boolean[] check, int[] num, int target) {
		if(N == count) {
			int result = 0;
			for (int i = 0; i < check.length; i++) {
				if(check[i]) result += num[i];
				else result -= num[i];
			}
			if(target == result) answer++;
			return;
		}
		check[count] = true;
		powerset(N, count+1, check, num, target);
		check[count] = false;
		powerset(N, count+1, check, num, target);
	}
}
