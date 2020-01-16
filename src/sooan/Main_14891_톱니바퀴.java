package sooan;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14891_톱니바퀴 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] gear = new int[4][8];
		for (int i = 0; i < gear.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				gear[i][j] = str.charAt(j)-'0'; //톱니 0:N극, 1:S극
			}
		}
		int K = Integer.parseInt(br.readLine());
		int[][] rotation = new int[K][2];
		for (int i = 0; i < rotation.length; i++) {
			String[] str = br.readLine().split(" ");
			rotation[i][0] = Integer.parseInt(str[0]);	//회전시킨 톱니바퀴번호
			rotation[i][1] = Integer.parseInt(str[1]);  //방향 1:시계 , -1:반시계
		}
		int[] twelve = new int[4];	//gear의 12시방향 인덱스를 저장, 초기값 0
		
		for (int i = 0; i < rotation.length; i++) {
			//3번톱니 12시 인덱스 -2 번째 와 2번 톱니의 12시인덱스 +2번째 비교
			//3번톱니 12시 인덱스 +2 번째 와 4번 톱니의 12시인덱스 -2번째 비교
			int r = rotation[i][0]-1; 
			int dir = rotation[i][1];
			int dirR = rotation[i][1];
			int dirL = rotation[i][1];
			int nowRight = gear[r][(twelve[r]+2 + 8) % 8];
			int nowLeft = gear[r][(twelve[r]-2 + 8) % 8];
			
			if(r == 0 || r == 1 || r== 2) {
				//현재 톱니와 오른쪽 톱니가 다른 극이면
				for (int j = r; j+1 < twelve.length; j++) {
					if(nowRight != gear[j+1][(twelve[j+1]-2 + 8) % 8] ) {
						nowRight = gear[j+1][(twelve[j+1]+2 + 8) % 8];
						if(dirR==-1) { //현재 톱니가 반시계로 돌면 옆의 톱니는 시계로
							twelve[j+1] = (twelve[j+1]-1 + 8) % 8;
						}
						else {	//현재 톱니가 시계로 돌면 옆의 톱니는 반시계로
							twelve[j+1] = (twelve[j+1]+1 + 8) % 8;
						}
						
						dirR *= -1;
					}else {
						break;
					}
				}
			}if(r == 1 || r == 2 || r== 3) {
				//현재 톱니와 왼쪽 톱니가 다른 극이면
				for (int j = r; j-1 >=0; j--) {
					
					if(nowLeft != gear[j-1][(twelve[j-1]+2 + 8) % 8] ) {
						nowLeft = gear[j-1][(twelve[j-1]-2 + 8) % 8];
						if(dirL==-1) { //현재 톱니가 반시계로 돌면 옆의 톱니는 시계로
							twelve[j-1] = (twelve[j-1]-1 + 8) % 8;
						}
						else {	//현재 톱니가 시계로 돌면 옆의 톱니는 반시계로
							twelve[j-1] = (twelve[j-1]+1 + 8) % 8;
						}
						
						dirL *= -1;
					}else {
						break;
					}
				}
			}
			if(dir==-1) {
				twelve[r] = (twelve[r]+1 + 8) % 8;
			}else {
				twelve[r] = (twelve[r]-1 + 8) % 8;
			}
			
//			System.out.println(Arrays.toString(twelve));
		}
		int ans = 0;
		for (int i = 0; i < twelve.length; i++) {
			if(gear[i][twelve[i]] == 1) {
				ans += Math.pow(2, i);
			}
		}
		System.out.println(ans);
	}
}
