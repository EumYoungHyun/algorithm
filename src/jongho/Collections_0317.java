package jongho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Collections_0317 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] months = {0,2,0,1,0,1,0,0,1,0,1,0};
		int day=-1;
		System.out.println("현재 년도 입력");
		String year = br.readLine();
		System.out.println("현재 월 입력");
		String month = br.readLine();
		
		int mm = months[Integer.parseInt(month)-1];
		if(mm==0) day=31;
		else if(mm==1) day=30;
		else if(mm==2) {
			int yy = Integer.parseInt(year);
			if((yy%4==0) && (yy%100!=0)|| (yy%400)==0) {
				day=29;
			}else day=28;
		}
		
		System.out.println(year+"년 "+month+"월의 날수는 "+day+"일 입니다." );
	}
}
