package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17837_새로운게임2 {
	class horse{
		public int r;
		public int c;
		public int dirs;
		public horse(int r, int c, int dirs) {
			super();
			this.r = r;
			this.c = c;
			this.dirs = dirs;
		}
		@Override
		public String toString() {
			return "horse [r=" + r + ", c=" + c + ", dirs=" + dirs + "]";
		}
 	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
	}
}
