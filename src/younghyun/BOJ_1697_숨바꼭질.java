package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1697_숨바꼭질 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int loc = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o1[1]-o2[1];
			}
		});
		HashSet<Integer> set = new HashSet<Integer>();
		queue.add(new Integer[] {loc, 0});
		Integer[] info;
		int result = 0 ;
		while(!queue.isEmpty()) {
			info = queue.poll();
			if(set.contains(info[0])) continue;
			set.add(info[0]);
			if(info[0] == goal) {
				result = info[1];
				break;
			}
			if(info[0] > 0) queue.add(new Integer[] {info[0]-1, info[1]+1});
			if(info[0] < goal) { 
				queue.add(new Integer[] {info[0]*2, info[1]+1});
				queue.add(new Integer[] {info[0]+1, info[1]+1});
			}
		}
		System.out.println(result);
	}
}
