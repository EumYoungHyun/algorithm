package sungchan;

public class Programmers_전화번호목록 {
	public static void main(String[] args) {
		System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
		System.out.println(solution(new String[]{"123","456","789"}));
		System.out.println(solution(new String[]{"12","123","1235","567","88"}));
	}
	
	public static boolean solution(String[] phone_book) {
        for(int i=0; i<phone_book.length; i++) {
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[i].charAt(0) == phone_book[j].charAt(0)) {
                    if(phone_book[i].length() > phone_book[j].length()) {
                        if(phone_book[i].contains(phone_book[j])) {
                            return false;
                        }
                    } else {
                        if(phone_book[j].contains(phone_book[i])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
