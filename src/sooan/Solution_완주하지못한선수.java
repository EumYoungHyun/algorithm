package sooan;

import java.util.HashMap;
import java.util.Map;

public class Solution_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String,Integer> pmap = new HashMap<>();
        for (String s : participant) {
        	if(pmap.get(s) == null) {
        		pmap.put(s, 1);
        	}else {
        		pmap.put(s, pmap.get(s)+1);
        	}
		}
        for (String c : completion) {
        	pmap.put(c, pmap.get(c)-1);
        }
        for(String s : pmap.keySet()) {
        	if(pmap.get(s)==1) {
        		answer = s;
        		break;
        	}
        }
        return answer;
    }
}
