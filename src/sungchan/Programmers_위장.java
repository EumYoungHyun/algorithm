package sungchan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers_위장 {
	public static void main(String[] args) {
		 System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
		 System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
	}
	
	public static int solution(String[][] clothes) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for(int i=0; i<clothes.length; i++) {
            ArrayList<String> list = new ArrayList<String>();
            
            if(map.containsKey(clothes[i][1])) {
                list = map.get(clothes[i][1]);
            }
            
            list.add(clothes[i][0]);
            map.put(clothes[i][1], list);
        }
        
        List<String> keys = new ArrayList(map.keySet());
        int size[] = new int[keys.size()];
        
        for(int i=0; i<keys.size(); i++) {
            size[i] = map.get(keys.get(i)).size();
        }
        
        int result = 1;
        
        for(int i=0; i<size.length; i++) {
            result = result * (size[i]+1);
        }
        result--;
        
        return result;
    }
}
