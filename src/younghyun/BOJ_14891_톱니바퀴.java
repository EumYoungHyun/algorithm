package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {
	public static void main(String[] args) throws Exception {

		// 입력

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] gears = new int[4][8];
		for (int i = 0; i < gears.length; i++) {
			String gearInfo = br.readLine();
			for (int j = 0; j < gearInfo.length(); j++) {
				gears[i][j] = gearInfo.charAt(j) - '0';
			}
		}
		int turnAmount = Integer.parseInt(br.readLine());
		// 회전
		int[] topIndex = new int[4];
		for (int i = 0; i < turnAmount; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int turnGearIndex = Integer.parseInt(st.nextToken());
			int turnDerection = Integer.parseInt(st.nextToken());

			turn(gears, topIndex, turnGearIndex, turnDerection);
		}

		// 결과 산출
		int weight = 1;
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (gears[i][topIndex[i]] == 1)
				result += weight;
			weight *= 2;
		}
		System.out.println(result);
	}// end of main

	/**
	 * 회전 경우에 따른 topIndex 변화
	 * 
	 * @param topIndex      톱니바퀴 위쪽을 가르키는 index배열
	 * @param gearNum       회전하는 톱니바퀴
	 * @param turnDirection 회전하는 방향
	 */
	public static void turn(int[][] gears, int[] topIndex, int gearNum, int turnDirection) {

		// 회전할 때 극이 다르면 회전한 반대방향으로 회전한다.
		switch (gearNum) {
		case 1:
			int right = topIndex[0] + 2;
			if (right >= 8)
				right -= 8;
			int left = topIndex[1] - 2;
			if (left < 0)
				left += 8;

			topIndex[0] = turn(topIndex[0], turnDirection);
			if (gears[0][right] != gears[1][left]) {
				right = topIndex[1] + 2;
				if (right >= 8)
					right -= 8;
				left = topIndex[2] - 2;
				if (left < 0)
					left += 8;

				topIndex[1] = turn(topIndex[1], -1 * turnDirection);
				if (gears[1][right] != gears[2][left]) {
					right = topIndex[2] + 2;
					if (right >= 8)
						right -= 8;
					left = topIndex[3] - 2;
					if (left < 0)
						left += 8;

					topIndex[2] = turn(topIndex[2], turnDirection);
					if (gears[2][right] != gears[3][left]) {
						topIndex[3] = turn(topIndex[3], -1 * turnDirection);
					}
				}
			}
			break;

		case 2:
			right = topIndex[0] + 2;
			if (right >= 8)
				right -= 8;
			left = topIndex[1] - 2;
			if (left < 0)
				left += 8;

			if (gears[0][right] != gears[1][left]) {
				topIndex[0] = turn(topIndex[0], -1 * turnDirection);
			}

			right = topIndex[1] + 2;
			if (right >= 8)
				right -= 8;
			left = topIndex[2] - 2;
			if (left < 0)
				left += 8;

			topIndex[1] = turn(topIndex[1], turnDirection);
			if (gears[1][right] != gears[2][left]) {
				right = topIndex[2] + 2;
				if (right >= 8)
					right -= 8;
				left = topIndex[3] - 2;
				if (left < 0)
					left += 8;

				topIndex[2] = turn(topIndex[2], -1 * turnDirection);
				if (gears[2][right] != gears[3][left]) {
					topIndex[3] = turn(topIndex[3], turnDirection);
				}
			}

			break;

		case 3:
			right = topIndex[2] + 2;
			if (right >= 8)
				right -= 8;
			left = topIndex[3] - 2;
			if (left < 0)
				left += 8;

			if (gears[2][right] != gears[3][left]) {
				topIndex[3] = turn(topIndex[3], -1 * turnDirection);
			}

			right = topIndex[1] + 2;
			if (right >= 8)
				right -= 8;
			left = topIndex[2] - 2;
			if (left < 0)
				left += 8;

			topIndex[2] = turn(topIndex[2], turnDirection);
			if (gears[1][right] != gears[2][left]) {
				right = topIndex[0] + 2;
				if (right >= 8)
					right -= 8;
				left = topIndex[1] - 2;
				if (left < 0)
					left += 8;

				topIndex[1] = turn(topIndex[1], -1 * turnDirection);
				if (gears[0][right] != gears[1][left]) {
					topIndex[0] = turn(topIndex[0], turnDirection);
				}
			}

			break;

		case 4:
			right = topIndex[2] + 2;
			if (right >= 8)
				right -= 8;
			left = topIndex[3] - 2;
			if (left < 0)
				left += 8;

			topIndex[3] = turn(topIndex[3], turnDirection);
			if (gears[2][right] != gears[3][left]) {
				right = topIndex[1] + 2;
				if (right >= 8)
					right -= 8;
				left = topIndex[2] - 2;
				if (left < 0)
					left += 8;

				topIndex[2] = turn(topIndex[2], -1 * turnDirection);
				if (gears[1][right] != gears[2][left]) {
					right = topIndex[0] + 2;
					if (right >= 8)
						right -= 8;
					left = topIndex[1] - 2;
					if (left < 0)
						left += 8;

					topIndex[1] = turn(topIndex[1], turnDirection);
					if (gears[0][right] != gears[1][left]) {
						topIndex[0] = turn(topIndex[0], -1 * turnDirection);

					}
				}
				break;
			}

		}
	}

	public static int turn(int Location, int direction) {
		Location -= direction;
		if (Location == 8)
			return 0;
		if (Location < 0)
			return 7;
		return Location;
	}
}// end of class
