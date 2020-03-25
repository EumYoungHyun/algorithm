package sungchan;
import java.util.Arrays;

public class Programmers_여행경로 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
		System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
		System.out.println(Arrays.toString(solution(new String[][]{{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}})));
	}
	
	static String result[];
    static String temp[];
    static boolean visited[];
    public static String[] solution(String[][] tickets) {
        result = new String[tickets.length+1];
        temp = new String[tickets.length+1];
        visited = new boolean[tickets.length+1];
        
        solve("ICN", 0, tickets);
        
        return result;
    }
    
    public static void solve(String target, int index, String tickets[][]) {
        if(index >= result.length-1) {
        	temp[index] = target;
            if(result[0] == null) {
                for(int i=0; i<result.length; i++) {
                    result[i] = temp[i];
                }
            } else {
                boolean check = false;
                for(int i=0; i<result.length; i++) {
                    if(temp[i].compareTo(result[i]) < 0) {
                        check = true;
                        break;
                    } else if(temp[i].compareTo(result[i]) > 0){
                    	break;
                    }
                }
                
                if(check) {
                    for(int i=0; i<result.length; i++) {
                        result[i] = temp[i];
                    }
                }
            }
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(tickets[i][0].equals(target) && visited[i] == false) {
            	temp[index] = target;
            	visited[i] = true;
                solve(tickets[i][1], index+1, tickets);
                visited[i] = false;
            }
        }
    }
}
