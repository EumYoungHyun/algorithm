package jungsoo;

public class 프로그래머스_서머코딩윈터코딩2019_멀쩡한사각형_이정수 {
	public long solution(int w,int h) {
	       long ww=Long.parseLong(String.valueOf(w));
	       long hh=Long.parseLong(String.valueOf(h));
	       long big=ww>=hh?ww:hh;
	       long small=ww<hh?ww:hh;
	        while(small!=0){
	            long nmg=big%small;
	            big=small;
	            small=nmg;
	        }
	        long gcd=big;
	        if(gcd!=1){
	            return ww*hh-(ww+hh-gcd);
	        } else
	            return ww*hh-(ww+hh-1);
		}
}