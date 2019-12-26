package jungsoo;

import java.util.Arrays;
import java.util.Comparator;
public class 프로그래머스_가장큰수_이정수 {
	public String solution(int[] numbers) {
		String[] arr = new String[numbers.length];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numbers.length; i++) { // int를 String으로 변환
			arr[i] = String.valueOf(numbers[i]);
		}
		MyComparator my = new MyComparator();

		Arrays.sort(arr, my);

		boolean check = true;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i].equals("0")) {
				continue;
			} else {
				check = false; // 전부 안겹침
				break;
			}

		}

		if (check == true) { // 전부 0
			return arr[0];
		} else {
			for (String i : arr)
				sb.append(i);
		}

		String answer = sb.toString();
		return answer;
	}
}

class MyComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return (o2 + o1).compareTo(o1 + o2);
	}
}
