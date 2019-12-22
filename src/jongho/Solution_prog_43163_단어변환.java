package jongho;
import java.util.*;

//DFS,BFS
public class Solution_prog_43163_단어변환 {
	public static void main(String[] args) {
		String[]words = new String[] {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution("hit","cog", words));
	}
    public static String beg, tar;
    public static String[] word;
    public static int answer;
    public static  boolean[] visit;
    public static int solution(String begin, String target, String[] words) {
        beg=begin; tar=target; word = words;
        visit=new boolean[words.length];
        answer = Integer.MAX_VALUE;
        dfs(beg, 0);
        if(answer==Integer.MAX_VALUE) answer=0;
        return answer;
    }
    public static void dfs(String s, int cnt){
        if(cnt>=answer) return;      
        if(s.equals(tar)){
            answer=Math.min(cnt,answer);
            return;
        }
        for(int i=0; i<word.length; i++){
            if(word[i].equals(s) || visit[i]) continue;
            int c=0;
            for(int j=0; j<word[i].length(); j++){
                if(word[i].charAt(j)!=s.charAt(j)) c++;
            }
            if(c==1) {
                visit[i]=true;
                dfs(word[i],cnt+1);
                visit[i]=false;
            }
        }
    }
}