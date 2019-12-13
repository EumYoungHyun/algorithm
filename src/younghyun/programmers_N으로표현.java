package younghyun;

public class programmers_N으로표현 {
	private static int Number;
	private static int GN, min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		System.out.println(solution(5, 111));
		
	}
	public static int solution(int N, int number) {
		Number = number;
        GN = N;
		BruteForce(0, 0);
		if(min == Integer.MAX_VALUE) return -1;
		return min;
    }
	public static void BruteForce(int num, int count) {
		if(num == Number) {
			if(min > count && count <9) min = count;
			return;
		}
		if(count > 8) return;
		if(min <= count) return;
		int NewNum = 0;
		for (int i = 1; i < 8; i++) {
			NewNum = NewNum*10+GN;
			BruteForce(num+NewNum, count+i);
			BruteForce(num-NewNum, count+i);
			BruteForce(num/NewNum, count+i);
			BruteForce(num*NewNum, count+i);
		}
	}
}
