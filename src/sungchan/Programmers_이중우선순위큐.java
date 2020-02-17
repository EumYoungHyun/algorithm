package sungchan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Programmers_이중우선순위큐 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[]{"I 16","D 1"})));
		System.out.println(Arrays.toString(solution(new String[]{"I 7","I 5","I -5","D -1"})));
	}
	
	public static int[] solution(String[] operations) {
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<operations.length; i++) {
            String temp[] = operations[i].split(" ");
            
            if(temp[0].equals("I")) {
            	list.add(Integer.valueOf(temp[1]));
            	Collections.sort(list, new Comparator<Integer>() {
            		public int compare(Integer o1, Integer o2) {
            			return o1-o2;
            		}
				});
            } else if(temp[1].equals("1")) {
                if(list.size() > 0) {
                	list.remove(list.size()-1);
                }
            } else {
                if(list.size() > 0) {
                	list.remove(0);
                }
            }
        }
        
        int result[] = new int[2];
        
        if(list.size() > 0) {
        	result[0] = list.get(list.size()-1);
        	result[1] = list.get(0);
        }
        
        return result;
    }
}
