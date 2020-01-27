package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2290_LEDTest {
	private static StringBuilder sb;
	private static int len;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		len = Integer.parseInt(st.nextToken());
		String str = st.nextToken();
		int strlen = str.length();
		sb = new StringBuilder();
		
		// 가로길이 len+2, 세로길이 2*len+3
		int count = -1;
		//위
		while(count++ < strlen-1) {
			int temp = str.charAt(count)-'0';
			switch (temp) {
			case 1:
			case 4:
				Empty();
				break;
			default:
				Line();
				break;
			}
			sb.append(" ");
		}
		sb.append("\n");
		//가운데 위
		for (int z = 0; z < len; z++) {
			count = -1;
			while(count++ < strlen-1) {
				int temp = str.charAt(count)-'0';
				switch (temp) {
				case 1:
				case 2:
				case 3:
				case 7:
					Right();
					break;
				case 5:
				case 6:
					Left();
					break;
				default:
					Both();
					break;
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		//가운데
		count = -1;
		while(count++ < strlen-1) {
			int temp = str.charAt(count)-'0';
			switch (temp) {
			case 1:
			case 7:
			case 0:
				Empty();
				break;
			default:
				Line();
				break;
			}
			sb.append(" ");
		}
		sb.append("\n");
		
		//가운데 위
		for (int z = 0; z < len; z++) {
			count = -1;
			while(count++ < strlen-1) {
				int temp = str.charAt(count)-'0';
				switch (temp) {
				case 1:
				case 3:
				case 4:
				case 5:
				case 7:
				case 9:
					Right();
					break;
				case 2:
					Left();
					break;
				default:
					Both();
					break;
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		//아래
		count = -1;
		while(count++ < strlen-1) {
			int temp = str.charAt(count)-'0';
			switch (temp) {
			case 1:
			case 4:
			case 7:
				Empty();
				break;
			default:
				Line();
				break;
			}
			sb.append(" ");
		}
		sb.append("\n");
		
		System.out.println(sb);
	}
	public static void Line() {
		sb.append(" ");
		for (int i = 0; i < len; i++) {
			sb.append("-");
		}
		sb.append(" ");
	}
	public static void Empty() {
		for (int i = 0; i < len+2; i++) {
			sb.append(" ");
		}
	}
	public static void Left() {
		sb.append("|");
		for (int i = 0; i < len+1; i++) {
			sb.append(" ");
		}
	}
	public static void Right() {
		for (int i = 0; i < len+1; i++) {
			sb.append(" ");
		}
		sb.append("|");
	}
	public static void Both() {
		sb.append("|");
		for (int i = 0; i < len; i++) {
			sb.append(" ");
		}
		sb.append("|");
		
	}
}
