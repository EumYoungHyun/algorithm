package younghyun;

public class programmers_SC_Level1_01 {
	public static void main(String[] args) {
		int n = 12;
		System.out.println(solution(n));
	}
	public static int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if(n%i == 0) answer += i; 
		}
		return answer;
    }
}
