package sooan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_가장먼노드 {
    public static void main(String[] args) {
    	Solution_가장먼노드 s = new Solution_가장먼노드();
    	int n = 6;
    	int[][] edge = {
    			{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}
    	};
    	System.out.println(s.solution(n, edge));
	}
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < edge.length; i++) {
            list.add(new ArrayList<Integer>()); 
        }
        for(int i = 0; i < edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }

        int[] depth = new int[n+1];
        Arrays.fill(depth, -1);
        depth[1] = 0;
        q.add(1);
        int v = 0;
        while(q.size() > 0) {
            v = q.poll();
            for(int e : list.get(v)) {
                if(depth[e] == -1) {
                    depth[e] = depth[v]+1;
                    q.add(e);
                }
            }

        }
        int cnt = 0;
        int max = depth[0];
        for(int i : depth) {
            if(max < i) {
                max = i;
                cnt = 1;
            }else if(max == i){
                cnt++;
            }
        }
        return cnt;
    }
}
