package sungchan;

public class Programmers_단어변환 {
	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
		System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
	}
	
	static boolean visited[];
    static int result;
    
    public static int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        result = Integer.MAX_VALUE;
        
        solve(begin, target, words, 0);
        
        if(result == Integer.MAX_VALUE) {
            result = 0;
        }
        
        return result;
    }
    
    public static void solve(String value, String target, String words[], int sum) {
        if(value.equals(target)) {
            result = Math.min(result, sum);
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(!visited[i]) {
                int count = 0;
                
                for(int a=0; a<value.length(); a++) {
                    if(value.charAt(a) != words[i].charAt(a)) {
                        count++;
                    }
                }
                
                if(count == 1) {
                    visited[i] = true;
                    solve(words[i], target, words, sum+1);
                    visited[i] = false;
                }
            }
        }
    }
}
