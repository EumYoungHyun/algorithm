package jongho;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Graph
public class Solution_prog_49189_가장먼노드 {
	public static void main(String[] args) {
		int[][] edges = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		int n = 6;
		System.out.println(solution(n,edges));
	}
    public static int[] node;
    public static int solution(int n, int[][] edges) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0; i<=n; i++){
            arr.add(new ArrayList<Integer>());
        }
        for(int i=0; i<edges.length; i++){
            arr.get(edges[i][0]).add(edges[i][1]);
            arr.get(edges[i][1]).add(edges[i][0]);
        }
        node = new int[n+1];
        Arrays.fill(node, Integer.MAX_VALUE);
        node[1]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int m = q.poll();
            for(int i=0; i<arr.get(m).size(); i++){
                int k = arr.get(m).get(i);
                if(node[k]==Integer.MAX_VALUE) q.add(k);
                node[k]=Math.min(node[m]+1,node[k]);
            }
        }
        int max=0;
//        System.out.println(Arrays.toString(node));
        for(int i=1; i<node.length; i++){
        	max=Math.max(node[i],max);
        }
        for(int i=1; i<node.length; i++) {
        	if(max==node[i]) answer++;
        }
        return answer;
    }
}