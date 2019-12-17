package jungsoo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class 프로그래머스_위장_이정수 {
	
	public int solution(String[][] clothes) {
    	HashMap<String,Integer> map=new HashMap<>();
    ArrayList<String> arr=new ArrayList<String>();
    int answer = 1;
    
    for(int i=0;i<clothes.length;i++) {
    	arr.add(clothes[i][1]);
    }
    
    Collections.sort(arr);
    
    String check=arr.get(0);
    int cnt=0;
 
    for(int i=0;i<arr.size();i++) {
    	if(check.equals(arr.get(i))) {
    		cnt++;
    		map.put(check,cnt);
    	}
    	else {
    		cnt=1;
    		check=arr.get(i);
    		map.put(check,cnt);	
    	}
    }
    
   for(String key:map.keySet()) {
	   answer*=(map.get(key)+1);
   }

    return answer-1;
}

}
