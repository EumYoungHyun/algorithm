package sungchan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_종이접기 {
	public static void main(String[] args) {
		int n = 3;
		System.out.println(Arrays.toString(solution(n)));
	}
	
	public static int[] solution(int n) {
	      List<Integer> list = new ArrayList<Integer>();
	      
	      while(n-- > 0) {
	          list.add(0);
	          for(int i=list.size()-2; i>=0; i--) {
	              list.add((list.get(i)+1)%2);
	          }
	      }
	      
	      int result[] = new int[list.size()];
	      
	      for(int i=0; i<result.length; i++) {
	          result[i] = list.get(i);
	      }
	      
	      return result;
	  }
}
