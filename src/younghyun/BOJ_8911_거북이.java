package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8911_거북이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String order = br.readLine();
			int dir = 0;
			
			int x = 0;
			int y = 0;
			
			int Mtop = 0;
			int Mleft = 0;
			int Mright = 0;
			int Mbottom = 0;

			for (int j = 0; j < order.length(); j++) {
				
				//dir 0:북   1:동  2:남  3:서
				char temp = order.charAt(j);
				switch (temp) {
				case 'F':
					x += dirs[dir][0];
					y += dirs[dir][1];
					if(x < Mtop) Mtop = x;
					if(y < Mleft) Mleft = y;
					if(x > Mbottom) Mbottom = x;
					if(y > Mright) Mright = y;
					break;
				case 'B':
					x -= dirs[dir][0];
					y -= dirs[dir][1];
					if(x < Mtop) Mtop = x;
					if(y < Mleft) Mleft = y;
					if(x > Mbottom) Mbottom = x;
					if(y > Mright) Mright = y;
					break;
				case 'R':
					dir++;
					if(dir==4) dir=0;
					break;
				case 'L':
					dir--;
					if(dir==-1) dir=3;
					break;
				}
			}
			int result = (Mbottom-Mtop)*(Mright-Mleft);
			System.out.println(result);
		}
	}
	public static int[][] dirs= {{-1, 0},{0, 1},{1, 0},{0, -1}};
}
