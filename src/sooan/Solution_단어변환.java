package sooan;

public class Solution_단어변환 {
	public static void main(String[] args) {
		Solution_단어변환 s = new Solution_단어변환();
		String begin = "hot";
		String target = "lot";
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		System.out.println(s.solution(begin, target, words));
	}
    public int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited,0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    public void dfs(String begin, String target, String[] words, boolean[] visited,int k){
        if(begin.equals(target)){
            if(answer > k) answer = k;
            return;
        }
        for(int i=0; i<words.length; i++){
        	if(words[i].equals(begin)) 
        		visited[i] = true;
        	if(visited[i])
        		continue;
            int len = 0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) == words[i].charAt(j)){
                    len++;
                }
            }
            if(len==begin.length()-1){
                visited[i] = true;
                dfs(words[i], target, words, visited, k+1);
                visited[i] = false;
            }
        }
    }
}
