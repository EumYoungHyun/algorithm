package younghyun;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * 문자열의 길이 최대 7
 * perm 내부에서 powerset을 돌리기에는 부담이 될 수 있지만
 * hashset으로 가지를 치면 충분히 돌아갈 것이라고 예상됨.
 * 
 * 소수 여부 확인은 모든 항목을 다 구하고 한번에 계산해서 시간을 줄인다.
 */
public class programmers_SC_Level2_02 {
	private static HashSet<Integer> set = new HashSet<>();
	private static int answer;
	private static int[] nums;
	private static String num;
	private static boolean[] chk;
	public static void main(String[] args) {
		String numbers= "011";
		//숫자 조합 만들기 -> 순열속에서 powerset을 통한 수조합
		System.out.println(solution(numbers));
	}
	public static int solution(String numbers) {
        
		nums = new int[numbers.length()];
		for (int i = 0; i < nums.length; i++) {
			nums[i] =  numbers.charAt(i)-'0';
		}
		// 진행순서 : solution -> perm -> powerset
		perm(0);
		int[] result = new int[set.size()];
		ArrayList temp = new ArrayList(set);
		int max = 0;
		for (int i = 0; i < result.length; i++) {
			result[i] =  (int) temp.get(i);
			if(max < result[i]) max = result[i];
		}
		boolean[] sosu = new boolean[max+1];
		for (int i = 2; i*i < sosu.length ; i++) {
			for (int j = 2; i*j < sosu.length; j++) {
				sosu[j*i] = true;
			}
		}
		for (int i = 0; i < result.length; i++) {
			if(!sosu[result[i]]) {
				System.out.println(result[i]);
				answer++;
			}
		}
		return answer;
    }
	public static void perm(int r) {
		if(r >= nums.length) {	//순열 탈출조건
			num= "";
			for (int i : nums) {
				num += i;
			}
			if(set.contains(Integer.parseInt(num))) return;
			set.add(Integer.parseInt(num));
			chk = new boolean[num.length()];
			powerset(0);
			return;
		}
		//순열 구현
		for (int i = r; i < nums.length; i++) {
			int temp = nums[r];
			nums[r] = nums[i];
			nums[i] = temp;
			perm(r+1);
			temp = nums[r];
			nums[r] = nums[i];
			nums[i] = temp;
		}
	}
	public static void powerset(int r) {
		if(r>= num.length()) {	//powerset 탈출 조건
			String temp= "";
			for (int i = 0; i < chk.length; i++) {
				if(chk[i]) temp+=nums[i];
			}
			if(temp.equals("")) return;
			if(set.contains(Integer.parseInt(temp))) return;
			if(Integer.parseInt(temp) <=1) return;
			set.add(Integer.parseInt(temp));
			/**
			 *  중복을 제거하고 가능한 모든 조합 구현 완료
			 *  solution 매서드에서 set을 이용한 계산진행
			 */
			return;
		}
		//powerset 구현
		chk[r] = true;
		powerset(r+1);
		chk[r] = false;
		powerset(r+1);
	}
}
