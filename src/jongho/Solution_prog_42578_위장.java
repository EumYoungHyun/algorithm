package jongho;
import java.util.HashMap;
public class Solution_prog_42578_위장 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<String,Integer>();
        for(int i=0; i<clothes.length; i++){
            if(hm.containsKey(clothes[i][1])){
                hm.put(clothes[i][1],hm.get(clothes[i][1])+1);
            }else{
                hm.put(clothes[i][1],1);
            }
        }
        for(int val : hm.values()){
            answer*=(val+1);
        }
        return answer-1;
    }
}
