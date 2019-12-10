package younghyun;

import java.util.Arrays;
import java.util.Comparator;

public class programmers_가장큰수 {

	public static void main(String[] args) {
		int[] numbers = {0, 0, 0, 0, 0};
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		StringBuilder sb = new StringBuilder();
		Integer[] temp = new Integer[numbers.length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = numbers[i];
		}
		Arrays.sort(temp, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String t1 = o1+"";
				String t2 = o2+"";
				
				return (t2+t1).compareTo(t1+t2);
			}
		});
		for (int i = 0; i < temp.length; i++) {
			sb.append(temp[i]);
		}
		if(sb.substring(0, 1).equals("0")) {
			return "0";
		}
		return sb.toString();
	}
}
