package younghyun;

public class programmers_다음큰숫자 {
	public static void main(String[] args) {
		programmers_다음큰숫자 s = new programmers_다음큰숫자();
		System.out.println(s.solution(78));
	}

	public int solution(int n) {
		int count = 0;
		int temp = n;
		while (n != 0) {
			if(n % 2 == 1) count++;
			n/=2;
		}
		while(true) {
			temp++;
			n = temp;
			int cnt = 0;
			while(n!=0) {
				if(n % 2 == 1) cnt++;
				n/=2;
			}
			if(cnt == count) break;
		}
		return temp;
	}
}
