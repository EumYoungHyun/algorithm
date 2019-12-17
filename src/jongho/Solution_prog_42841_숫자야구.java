package jongho;
import java.util.*;

public class Solution_prog_42841_숫자야구 {	
    public static int[] arr;
    public static int[][] bb;
    public static int answer;
	public static void main(String[] args) {
		int [][] baseball=new int[][] {{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
		System.out.println(solution(baseball));
	}
    public static int solution(int[][] baseball) {
        answer = 0;
        arr=new int[3];
        bb=baseball;
        for(int i=1; i<8; i++){
            arr[0]=i;
            for(int j=i+1; j<9; j++){
                arr[1]=j;
                for(int k=j+1; k<10; k++){
                    arr[2]=k;
                    perm(arr.length,0);
                }
            }
        }
        return answer;
    }
    public static void perm(int n, int k){
        if(n==k){
        	int chk=0;
            for(int i=0; i<bb.length; i++){
                chk+=check(i);
            }
            if(chk==bb.length) answer++;
        }else{
            for(int i=k; i<n; i++){
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
                perm(n,k+1);
                temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
            }
        }
    }
    public static int check(int n){
        String s =""+bb[n][0];
        int str = bb[n][1];
        int ball=bb[n][2];
        //System.out.println(s+ " " +str + " " +ball + " "+Arrays.toString(arr));
        for(int i=0; i<s.length(); i++){
	        for(int j=0; j<s.length(); j++){
	            if(s.charAt(i)-'0' == arr[j]) {
	                if(i==j) str--;
	                else ball--;
	                break;
	            }
	        }
        }
        if(ball==0 && str==0){
        	return 1;
        }
        return 0;
    }
}
