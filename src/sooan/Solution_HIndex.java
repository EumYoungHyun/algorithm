package sooan;

public class Solution_HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < citations.length; i++) {
			if(max<citations[i]) max = citations[i];
		}
        for (int h = 0; h <= max; h++) {
        	int cnt = 0;
			for (int j = 0; j < citations.length; j++) {
				if(citations[j] >= h) cnt++;
			}
			if(cnt >= h && h > answer) answer = h;
		}
        return answer;
    }
}
