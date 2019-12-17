package jungsoo;
import java.util.*;

public class 프로그래머스_여행경로_이정수 {

	boolean visited[];
	int cnt = 0;
	ArrayList<String> list;

	public String[] solution(String[][] tickets) {
		String[] answer;
		visited = new boolean[tickets.length];
		list = new ArrayList<>();
		Arrays.sort(tickets, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if (o1[0].equals(o2[0]))
					return o1[1].compareTo(o2[1]);
				return o1[0].compareTo(o2[0]);
			}
		});
		for (int i = 0; i < tickets.length; i++) {
			if (!tickets[i][0].equals("ICN"))
				continue;
			visited[i] = true;
			cnt++;
			list.add(tickets[i][0]);
			dfs(i, tickets);
			if (cnt == tickets.length)
				break;
			list.remove(list.size() - 1);
			cnt--;
			visited[i] = false;
		}
		answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++)
			answer[i] = list.get(i);
		return answer;
	}

	public void dfs(int start, String[][] tickets) {
		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i]) {
				if (tickets[start][1].equals(tickets[i][0])) {
					cnt++;
					visited[i] = true;
					list.add(tickets[start][1]);
					if (cnt == tickets.length)
						list.add(tickets[i][1]);
					dfs(i, tickets);
					if (cnt == tickets.length)
						return;
					list.remove(list.size() - 1);
					visited[i] = false;
					cnt--;
				}
			}
		}
	}

}