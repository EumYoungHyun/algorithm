package sooan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_소수찾기 {
	public static void main(String[] args) {
		Solution_소수찾기 s = new Solution_소수찾기();
		String numbers = "12345";
		System.out.println(s.solution(numbers));
	}
	private static int[] num;
	private static int cnt = 0;
	private static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        num = new int[numbers.length()];
        for (int i = 0; i < num.length; i++) {
			num[i] = numbers.charAt(i) - '0';
		}
        powerset();
        return cnt;
    }
    public static void perm(int n, int k, int[] arr) {
    	if(n==k) {
    		int val = 0;
    		int ten = 1;
    		for (int i = arr.length-1; i >=0 ; i--) {
				val += arr[i] * ten;
				ten *= 10;
			}
    		
    		if(val %2 ==0 && val!=2) return; //짝수로 끝나면 pass
    		if(val == 1) return;
    		
    		if(set.contains(val)) return; //이미 찾은 수면 return
    		set.add(val);
    		
    		//2~n-1 까지 나눠지는 수가 없는 지 찾기
    		for (int i = 2; i < val; i++) {
				if(val % i == 0) {
					return;
				}
			}
    		cnt++;
    	}else {
    		for (int i = k; i < arr.length; i++) {
				int tmp = arr[k];
				arr[k] = arr[i];
				arr[i] = tmp;
				perm(n,k+1,arr);
				tmp = arr[k];
				arr[k] = arr[i];
				arr[i] = tmp;
			}
    	}
    }
    public static void powerset() {
    	int[] arr = new int[num.length];
    	int idx = 0;
		for (int i = 0; i < (1 << num.length); i++) {
			for (int j = 0; j < num.length; j++) {
				if((i & (1 << j)) != 0 ) {
					arr[idx++] = num[j];
				}
			}
			//뒤의 0 무시하기 위해 새로운 배열에 옮기기
			int[] tmp = new int[idx];	
			for (int j = 0; j < idx; j++) {
				tmp[j] = arr[j];
			}
			idx = 0;
			if(tmp.length!=0) {
				perm(tmp.length,0,tmp);
			}
		}
    }
}
