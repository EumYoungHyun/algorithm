package jongho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_boj_2644_촌수계산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int man1 =Integer.parseInt(st.nextToken());
		int man2 =Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());	// 부모자식 간의 관계
		int[] parent = new int[N+1];				// 부모 저장, 0번은 안씀
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			parent[c]=p;	// 부모 저장
		}
		//      사람번호,   촌수
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		// man 1의 조상으로 올라가며 촌수 기록
		int val = 0; // 촌수
		while(man1 != 0) {
			hm.put(man1, val++);
			man1 = parent[man1];	// 부모값 넣기
		}
		
		// man2의 조상으로 올라가며 man1과 공통조상 있는지 검사
		val = 0;	// 촌수
		while(man2 != 0) {
			if(hm.containsKey(man2)) {	// 공통조상인가?
				System.out.println(hm.get(man2)+val);
				return;
			}
			val++;
			man2 = parent[man2]; // 부모값을 넣기
		}
		System.out.println(-1);	// 공통조상 못찾음
	}
}
