package sooan;

public class Solution_2016년 {
	public String solution(int a, int b) {
		String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		int[] month = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] year = new String[366];
		int d = 0;
		for (int i = 0; i < year.length; i++) {
			year[i] = day[(i + 5) % 7];
		}
		for (int i = 0; i < a-1; i++) {
			d += month[i];
		}
		d += b-1;
		
		return year[d];
	}
}
