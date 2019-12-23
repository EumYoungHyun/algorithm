package sooan;

public class Solution_카펫 {
	public int[] solution(int brown, int red) {
		int[] answer = new int[2];
		int total = brown + red;
		for (int i = 1; i <= total/2; i++) {
			if(total % i != 0) 
				continue;
			int n=i;
			int m = total / n;
			if(n < m) 
				continue;
			int tmpR= (n-2)*(m-2);
			int tmpB = total - tmpR;
			if(tmpR == red && tmpB == brown) {
				answer[0] = n;
				answer[1] = m;
				break;
			}
		}
		return answer;
	}
}
