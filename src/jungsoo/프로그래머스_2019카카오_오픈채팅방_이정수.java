package jungsoo;

import java.util.*;

public class 프로그래머스_2019카카오_오픈채팅방_이정수 {
	public String[] solution(String[] record) {
		String[] answer;
		ArrayList<String> list = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < record.length; i++) {
			String s[] = record[i].split(" ");
			if (s[0].equals("Enter")) {
				map.put(s[1], s[2]);
				list.add(s[1] + " " + s[2] + " 님이 들어왔습니다.");
			} else if (s[0].equals("Leave")) {
				list.add(s[1] + " " + map.get(s[1]) + " 님이 나갔습니다.");
			} else {
				map.put(s[1], s[2]);
			}
		}

		answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			String str[] = list.get(i).split(" ");
			if (str[3].equals("들어왔습니다."))
				answer[i] = map.get(str[0]) + "님이 들어왔습니다.";
			else
				answer[i] = map.get(str[0]) + "님이 나갔습니다.";
		}
		return answer;
	}
}