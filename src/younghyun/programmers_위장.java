package younghyun;

import java.util.HashMap;

class programmers_위장{
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] temp = new String[clothes.length];
        for(int i = 0; i<clothes.length; i++){
            String str = clothes[i][1];
            if(map.containsKey(str)){
                int a = map.get(str);
                map.put(str, a+1);
            }else{
                map.put(str, 1);
            }
        }
        int answer = 1;
        for(String s : map.keySet()){
         answer *= (map.get(s)+1);   
        }
        return answer-1;
    }
}