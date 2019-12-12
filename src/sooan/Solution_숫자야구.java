package sooan;

public class Solution_숫자야구 {
	public static void main(String[] args) {
		Solution_숫자야구 s = new Solution_숫자야구();
		int[][] baseball = {{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
		System.out.println(s.solution(baseball));
	}
	private static int[] trr = {1,2,3,4,5,6,7,8,9};
	private static int[][] baseball;
	private static int cnt;
    public int solution(int[][] baseball) {
        this.baseball = baseball;
        cnt = 0;
        perm(9,0);
        
        return cnt;
    }
    public static void checkCondition(int[] arr) {
    	for (int i = 0; i < baseball.length; i++) {
			int num = baseball[i][0];
			int[] nrr = new int[3];
			int ten = 100;
			for (int j = 0; j < nrr.length; j++) {
				nrr[j] = num/ten;
				num %= ten;
				ten /= 10;
			}
			int s = baseball[i][1];
			int b = baseball[i][2];
			
			//baseball 배열과 내가 정답일것이라고 예상하는 수의 s와 b가 같아야함
			int tmpS = 0;
			int tmpB = 0;
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					//숫자와 위치가 모두 맞을 때는 스트라이크
					if(j==k && nrr[j]==arr[k]) {
						tmpS++;
						if(s < tmpS) return;
					}
					//숫자는 맞지만 위치가 틀렸을 때는 볼
					else if(nrr[j] == arr[k]) {
						tmpB++;
						if(b < tmpB) return;
					}
				}
			}
			if(s!=tmpS || b!=tmpB) return;
		}
    	cnt++;
    }
    public static void perm(int n, int k) {
    	if(k==3) {
    		int[] data = new int[3];
    		for (int i = 0; i < 3; i++) {
				data[i] = trr[i];
			}
//    		System.out.println(Arrays.toString(data));
    		checkCondition(data);
    	}else {
    		for (int i = k; i < n; i++) {
				int tmp = trr[k];
				trr[k] = trr[i];
				trr[i] = tmp;
				perm(n,k+1);
				tmp = trr[k];
				trr[k] = trr[i];
				trr[i] = tmp;
			}
    	}
    }
}
