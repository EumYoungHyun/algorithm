package ���α׷��ӽ�;

import java.util.*;
import java.util.Map.Entry;
public class ���α׷��ӽ�_����Ʈ�ٹ�_������ {
	
	public int[] solution(String[] genres, int[] plays) {
		int[] answer;
		ArrayList<Integer> aList = new ArrayList<>();// �ӽ÷� ���� ���� ����Ʈ
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < plays.length; i++) {
			if (!map.containsKey(genres[i]))
				map.put(genres[i], plays[i]);
			else {
				int temp = map.get(genres[i]) + plays[i];
				map.put(genres[i], temp);
			}
		}

		// Map value���� �������� ���� --> entrySet�� map�� key, value ��� ������ ������
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		for (int i = 0; i < list.size(); i++) {// ���� ���� ����� �帣���� ����
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
			
			if (cnt != 1) { //�ش� �帣 ���ϰ��� 1���ۿ� ������ 2��° ���� ã�� �ʿ䰡 ����.
				for (int k = plays.length - 1; k >=0; k--) {
					if (gen.equals(genres[k]) && k!=max) { // 2��° ū��ã��
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
