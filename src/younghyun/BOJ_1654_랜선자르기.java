package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int LANCount = Integer.parseInt(st.nextToken());
		int requiredLAN = Integer.parseInt(st.nextToken());
		long[] LAN = new long[LANCount];
		long right = 0;
		for (int i = 0; i < LANCount; i++) {
			long lan = Long.parseLong(br.readLine());
			LAN[i] = lan;
			if(right < lan) right = lan;
		}
		long left = 1;
		long pivot;
		while (right >= left) {
			pivot = (left+right)/2;
			long count = 0;
			for (int i = 0; i < LAN.length; i++) {
				count += LAN[i] / pivot;
			}
			if(count >= requiredLAN) {
				left = pivot+1;
			}else {
				right = pivot-1;
			}
		}
		System.out.println(right);
	}
}
