package younghyun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class programmers_전화번호목록_음영현 {
	public static void main(String[] args) {
		String[] phone_book = {"123", "2356", "234"};
		
		System.out.println(Solution(phone_book));
	}

	public static boolean Solution(String[] phone_book) {
		boolean answer = false;
		
		//문자열을 짧은 순으로 나열
		Arrays.sort(phone_book, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
		HashSet<String> set = new HashSet<String>();
		
		for (int i = 0; i < phone_book.length; i++) {
			int len = phone_book[i].length();
			for (int j = 1; j < len; j++) {
				if(set.contains(phone_book[i].substring(0, j))) {
					return false;
				}
			}
			set.add(phone_book[i]);
		}
		
		return true;
	}

}
