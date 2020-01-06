package jungsoo;

public class 프로그래머스_서머코딩윈터코딩2018_점프와순간이동_이정수 {
	 public int solution(int n) {
	        int ans = 0;
	        while(n>0){
	            if(n%2!=0){
	                n-=1;
	                ans++;
	            } else{
	                n/=2;
	            }
	        }
	        return ans;
	    }
}