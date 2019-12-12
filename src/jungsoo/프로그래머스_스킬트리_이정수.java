package 프로그래머스;

public class 프로그래머스_스킬트리_이정수 {
	class Solution {
	    public int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        char[] sk=new char[skill.length()];
	        int []alpha;
	        sk=skill.toCharArray();
	        boolean flag=true;
	        for(int i=0;i<skill_trees.length;i++){
	            alpha=new int[26];
	            String s=skill_trees[i];
	            int index=0;
	            outer:for(int j=0;j<sk.length;j++){
	                char c=sk[j];
	                flag=true;
	                for(int k=0;k<s.length();k++){
	                    if(c==s.charAt(k)){
	                        if(j>0 && alpha[sk[j-1]-'A']==0){
	                            flag=false;
	                            break outer;
	                        }
	                        if(k<index){
	                            flag=false;
	                            break outer;
	                        } else{
	                            index=k;
	                            alpha[c-'A']++;
	                            break;
	                        }
	                    }
	                }
	            }
	            if(flag){
	                answer++;
	            }
	        }
	        return answer;
	    }
	}

}
