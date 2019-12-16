
public class 프로그래머스_단어변환_이정수 {
	int cnt = 0;
	int min = Integer.MAX_VALUE;
	boolean visited[];

	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		dfs(begin, target, words);
		if (min == Integer.MAX_VALUE)
			min = 0;
		return min;
	}

	public void dfs(String begin, String target, String[] words) {
		if (begin.equals(target)) {
			if (min > cnt)
				min = cnt;
		} else {
			for (int i = 0; i < words.length; i++) {
				int temp = 0;
				if (!visited[i]) {
					for (int j = 0; j < words[i].length(); j++) {
						if (words[i].charAt(j) != begin.charAt(j)) {
							temp++;
						}
					}
					if (temp == 1) {
						cnt++;
						visited[i] = true;
						dfs(words[i], target, words);
						visited[i] = false;
						cnt--;
					}
				}
			}
		}
	}
}