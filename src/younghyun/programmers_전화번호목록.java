package younghyun;

import java.util.Arrays;

public class programmers_전화번호목록 {
	public static void main(String[] args) {
		String[] phone_book = {"2343", "23456", "231"};
		
		System.out.println(Solution(phone_book));
	}

	public static boolean Solution(String[] phone_book) {
		
		Arrays.sort(phone_book);
		System.out.println(Arrays.toString(phone_book));
		for (int i = 0; i < phone_book.length -1; i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) {
				return false;
			}
		}
		
		return true;
	}

}
