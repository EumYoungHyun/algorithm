package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크 {
	private static int[] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		memo = new int[F+1];
		Queue<Integer[]> queue = new LinkedList<Integer[]>();
		queue.add(new Integer[] {S, 1});
		memo[S] = 1;
		while (!queue.isEmpty()) {
			int s = queue.peek()[0];
			int score = queue.poll()[1];
			if(s + U <= F && (memo[s+U] > score+1 || memo[s+U] == 0)) {
				memo[s+U] = score +1;
				queue.add(new Integer[] {s+U, score+1});
			}
			if(s - D > 0 && (memo[s-D] > score+1 || memo[s-D] == 0 )) {
				memo[s-D] = score +1;
				queue.add(new Integer[] {s-D, score+1});
			}
		}
		if(memo[G] == 0) System.out.println("use the stairs");
		else System.out.println(memo[G]-1);
	}
}
