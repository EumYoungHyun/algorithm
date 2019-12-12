package 프로그래머스;

import java.util.*;
import java.util.Map.Entry;
public class 프로그래머스_베스트앨범_이정수 {
	
	public int[] solution(String[] genres, int[] plays) {
		int[] answer;
		ArrayList<Integer> aList = new ArrayList<>();// 임시로 답을 담을 리스트
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < plays.length; i++) {
			if (!map.containsKey(genres[i]))
				map.put(genres[i], plays[i]);
			else {
				int temp = map.get(genres[i]) + plays[i];
				map.put(genres[i], temp);
			}
		}

		// Map value기준 내림차순 정렬 --> entrySet은 map의 key, value 모든 정보를 가져옴
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		for (int i = 0; i < list.size(); i++) {// 가장 많이 재생된 장르부터 뽑음
			int max = 0;
			int maxValue = 0;
			int second = 0;
			int secondValue = 0;
			int cnt = 0;
			String gen = list.get(i).getKey();
			for (int j = plays.length - 1; j >= 0; j--) {
				if (gen.equals(genres[j])) {
					cnt++;
					if (plays[j] >= maxValue) {
						max = j;
						maxValue = plays[j];
					}
				}
			}
			aList.add(max);
			
			if (cnt != 1) { //해당 장르 수록곡이 1개밖에 없으면 2번째 값을 찾을 필요가 없다.
				for (int k = plays.length - 1; k >=0; k--) {
					if (gen.equals(genres[k]) && k!=max) { // 2번째 큰값찾음
						if (plays[k] >= secondValue){
							second = k;
						    secondValue = plays[k];
                        }
					}
				}
				aList.add(second);
			}
		}
		answer=new int[aList.size()];
		for(int i=0;i<answer.length;i++) {
			answer[i]=aList.get(i);
		}

		return answer;
	}

}
