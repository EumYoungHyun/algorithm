package jongho;
import java.util.*;

//DFS,BFS
public class Solution_prog_43164_여행경로 {
	public static void main(String[] args) {
		String[][] ticket = new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		System.out.println(Arrays.toString(solution(ticket)));
	}
    public static String[] answer;
    public static String[][] tickets;
    public static boolean[] visit;
    public static ArrayList<ArrayList<String>> arr;
    public static ArrayList<String> a;
    public static String[] solution(String[][] ticket) {
        tickets=ticket;
        visit=new boolean[tickets.length];
        arr=new ArrayList<>();
        a=new ArrayList<>();
        a.add("ICN");
        dfs("ICN", 0);
        for(int i=1; i<ticket.length+1; i++){
            if(arr.size()==1) break;
            String min = arr.get(0).get(i);
            for(int j=1; j<arr.size(); j++){
                if(min.compareTo(arr.get(j).get(i))>0){
                    min=arr.get(j).get(i);
                }
            }
            for(int j=0; j<arr.size(); j++){
                if(min.compareTo(arr.get(j).get(i))<0){
                    arr.remove(j); j--;
                }
            }
        }
        answer=new String[arr.get(0).size()];
        for(int i=0; i<answer.length; i++){
            answer[i]=arr.get(0).get(i);
        }
        return answer;
    }
    public static void dfs(String s, int cnt){
        if(cnt==tickets.length) {
            ArrayList<String> newA = new ArrayList<>();
            newA.addAll(a);
            arr.add(newA);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(visit[i]==false && tickets[i][0].equals(s)) {
                visit[i]=true;
                a.add(tickets[i][1]);
                dfs(tickets[i][1],cnt+1);
                a.remove(a.size()-1);
                visit[i]=false;
            }
        }
    }
}