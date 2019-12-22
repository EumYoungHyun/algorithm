package jongho;
import java.util.*;

//DFS,BFS(Disjoint Set)
public class Solution_prog_43162_네트워크 {
	public static void main(String[] args) {
		int[][]computers = new int[][] {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(solution(3,computers));
	}
    public static int[] par;
    public static int[] rank;
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        par = new int[n];   // 부모 배열
        rank = new int[n];
        for(int i=0; i<par.length; i++){
            par[i]=i;
        }
        for(int i=0; i<computers.length; i++){
            for(int j=i+1; j<computers[i].length; j++){
                if(computers[i][j]==1) join(i,j);
            }
        }
        List<Integer> li = new ArrayList<>();
        for(int i=0; i<par.length; i++){
            int fn = find(par[i]);
            if(!li.contains(fn)){
                li.add(fn);
            }
        }
        answer=li.size();
        return answer;
    }
    public static int find(int n){
        if(par[n]!=n) par[n]=find(par[n]);
        return par[n];
    }
    public static void join(int n, int m){
        int fn=find(n), fm=find(m);
        if(fn==fm) return;
        else if(rank[fn]<rank[fm]){
            par[fm]=fn;
        }else if(rank[fn]==rank[fm]){
            rank[fn]++;
            par[fm]=fn;
        }else par[fn]=fm;
    }
}