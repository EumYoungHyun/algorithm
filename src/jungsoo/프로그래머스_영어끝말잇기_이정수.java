package jungsoo;

import java.util.HashSet;
public class 프로그래머스_영어끝말잇기_이정수 {
	public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set=new HashSet<>();
        int cnt=2;
        int round=1;
        set.add(words[0]);
        boolean flag=true;
        for(int i=1;i<words.length;i++){
            if(set.contains(words[i]) || (words[i].charAt(0) !=words[i-1].charAt(words[i-1].length()-1))){
               flag=false;
                break;
            }
            set.add(words[i]);
            cnt++;            
            if(cnt==n+1){
                cnt=1;
                round++;
            }
        }
        if(flag){
            answer[0]=0;
            answer[1]=0;
        } else{
            answer[0]=cnt;
            answer[1]=round;
        }
        return answer;
    }
}