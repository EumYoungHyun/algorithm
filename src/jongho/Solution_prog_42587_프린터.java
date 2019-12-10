package jongho;
import java.util.ArrayList;
public class Solution_prog_42587_프린터 {
    public int solution(int[] priorities, int location) {
		int answer=0, loc=location, res=-1;  
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		
		for(int i=0; i<priorities.length; i++) {
			arr.add(priorities[i]);
			arr2.add(i);
		}
		
		while(res!=loc) {
			int k =arr.remove(0);
			boolean ch=false;
			for(int i=0; i<arr.size(); i++) {
				if(k<arr.get(i)) {
					arr.add(k); ch=true;
					arr2.add(arr2.remove(0));
					break; 
				}
			}
			if(!ch) { res=arr2.remove(0); answer++; }
		}
		return answer;
    }
}
