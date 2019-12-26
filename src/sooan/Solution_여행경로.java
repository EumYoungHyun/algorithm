package sooan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_여행경로 {
	static List<String> list = new ArrayList<>();
	static String route = "";
	static boolean[] visited;
	
    public String[] solution(String[][] tickets) {
        
    	visited = new boolean[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
        	String departure = tickets[i][0];
    		String destination = tickets[i][1];
    		
			if(departure.equals("ICN")){
				visited[i] = true;
				route = departure + ",";
				dfs(tickets, destination, 1);
				visited[i] = false;
			}
		}
        
        Collections.sort(list);
        String[] answer = list.get(0).split(",");
        return answer;
    }
    public static void dfs(String[][] tickets, String end, int cnt) {
    	route += end + ",";
    	
    	if(cnt == tickets.length) {
    		list.add(route);
    		return;
    	}
    	for (int i = 0; i < tickets.length; i++) {
    		String departure = tickets[i][0];
    		String destination = tickets[i][1];
    				
			if(end.equals(departure) && !visited[i]){
				visited[i] = true;
				dfs(tickets, destination, cnt+1);
				visited[i] = false;
				route = route.substring(0, route.length()-4);
			}
		}
    }
}
