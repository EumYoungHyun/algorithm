package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] classroom = new int[N];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for (int i = 0; i < classroom.length; i++) {
			classroom[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int major = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		long answer = classroom.length;
		for (int i = 0; i < classroom.length; i++) {
			int temp = classroom[i];
			temp -= major;
			if(temp <= 0) continue;
			answer += temp/sub;
			if(temp % sub != 0) answer++;
		} 
		System.out.println(answer);
	}
}
