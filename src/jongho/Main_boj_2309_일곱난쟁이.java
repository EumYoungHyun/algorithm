package jongho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_boj_2309_일곱난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] m = new int[9];
		
		int sum = -100;
		for(int i=0; i<m.length; i++) {
			m[i] = Integer.parseInt(br.readLine());
			sum+=m[i];
		}
		Arrays.sort(m);
	
		int a=0;
		int b=0;
		// 키의 합이 sum(=전체합-100) 이 되는 두 난장이 찾기 *조합*
ex:		for(a=0; a<m.length; a++) {	// 1번 난장이
			for(b=0; b<m.length; b++) {	// 2번 난장이
				if(m[a]+m[b]==sum) {
					break ex;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m.length; i++) {
			if(i==a||i==b) continue;
			sb.append(m[i]).append('\n');
		}
		System.out.print(sb);
		
	}
}
