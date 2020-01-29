package sungchan;
import java.util.Arrays;

public class Programmers_숫자야구 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}}));
	}
	
	static int number[];
    static int tnum[];
    static int count;
    
    public static int solution(int[][] baseball) {
        number = new int[9];
        tnum = new int[3];
        count = 0;
        for(int i=0; i<number.length; i++) {
            number[i] = i+1;
        }
        
        makeC(number.length, tnum.length, baseball);
        
        return count;
    }
    
    public static void  makeC(int n, int r, int baseball[][]) {
        if(r < 1) {
            int temp[] = new int[3];
            for(int i=0; i<tnum.length; i++) {
                temp[i] = tnum[i];
            }
            makeP(temp, 0, baseball);
            return;
        } else if(n < r) {
            return;
        } else {
            tnum[r-1] = number[n-1];
            makeC(n-1, r-1, baseball);
            makeC(n-1, r, baseball);
        }
    }
    
    public static void makeP(int array[], int n, int baseball[][]) {
        if(n >= array.length) {
        	System.out.println(Arrays.toString(array));
            boolean ispossible = true;
            for(int i=0; i<baseball.length; i++) {
                String target = baseball[i][0] + "";
                int strike = 0;
                int ball = 0;
                for(int j=0; j<target.length(); j++) {
                    for(int k=0; k<array.length; k++) {
                        if(target.charAt(j)-'0' == array[k]) {
                            if(j == k) {
                                strike++;
                            } else {
                                ball++;
                            }
                            break;
                        }
                    }
                }
                
                if(strike != baseball[i][1] || ball != baseball[i][2]) {
                    ispossible = false;
                    break;
                }
            }
            
            if(ispossible) {
                count++;
            }
            return;
        }
        
        for(int a=n; a<array.length; a++) {
            int temp = array[a];
            array[a] = array[n];
            array[n] = temp;
            
            makeP(array, n+1, baseball);
            
            temp = array[a];
            array[a] = array[n];
            array[n] = temp;
        }
    }
}
