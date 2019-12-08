package younghyun;
import java.util.HashMap;

public class programmers_완주하지못한선수 {
	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] participant = { "1", "2", "1"};
		String[] completion = { "1", "2" };
		
		//새로 넣으면 기존의 값에 덮어씌워진다		getorDefault
		for (String element : participant) map.put(element, map.getOrDefault(element, 0)+1);
		//remove를 하지 않고 0이 아닌값을 확인만 한다.
		for (String element : completion) map.put(element, map.get(element)-1);
		
		String answer = "";
		// 전체 key들의 set
		for (String str: map.keySet()) {
			if(map.get(str) ==1) {
				answer = str;
				break;
			}
		}
		System.out.println(answer);
	}
}
