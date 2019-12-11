package younghyun;

import java.util.HashSet;

public class programmers_소수찾기 {
	private static char[] nums;
	private static HashSet<Integer> set = new HashSet<Integer>();
	private static boolean[] chk;
	public static void main(String[] args) {
		String str = "22211";
		System.out.println(solution(str));
	}
	public static int solution(String numbers) {
		nums = numbers.toCharArray();
		chk = new boolean[nums.length];
		//숫자 생성 조합 확인(순열+부분집합)
		perm(0);
        return set.size();
    }
	public static void powerset(int r) {
		if(r == nums.length) {
			String str = "";
			for (int i = 0; i < nums.length; i++) {
				if(chk[i]) str+=nums[i];
			}
			if(str.equals("")) return;
			int num = Integer.parseInt(str);
			if(set.contains(num)) return;
			if(num<=1) return;
			int cnt =0;
			for (int i = 1; i <= num; i++) {
				if(num%i == 0) cnt++;
				if(cnt>2) return;
			}
			System.out.println(num);
			set.add(num);
			return;
		}
		chk[r] = true;
		powerset(r+1);
		chk[r] = false;
		powerset(r+1);
	}
	public static void perm(int r) {
		if(r == nums.length) {
			String str = "";
			for (int i = 0; i < nums.length; i++) {
				str+=nums[i];
			}
			int num = Integer.parseInt(str);
			if(set.contains(num)) return;
			chk = new boolean[nums.length];
			powerset(0);
		}
		
		for (int i = r; i < nums.length; i++) {
			char temp = nums[i];
			nums[i] = nums[r];
			nums[r] = temp;
			
			perm(r+1);
			
			temp = nums[i];
			nums[i] = nums[r];
			nums[r] = temp;
		}
	}
}
