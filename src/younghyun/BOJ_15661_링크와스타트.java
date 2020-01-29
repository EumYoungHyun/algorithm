package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15661_링크와스타트 {
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int totalPeople = Integer.parseInt(br.readLine());
		boolean[] powersetArray = new boolean[totalPeople];
		int[][] synergyValue = new int[totalPeople][totalPeople];
		for (int i = 0; i < totalPeople; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < totalPeople; j++) {
				synergyValue[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		powerset(synergyValue, powersetArray, totalPeople - 1);
		
		System.out.println(min);
	}

	public static void powerset(int[][] synergyValue, boolean[] powersetArray, int nowIndex) {
		if(nowIndex <0) {
			int teamCapabilities = 0;
			int anotherTeamCapabilities = 0;
			for (int i = 0; i < powersetArray.length; i++) {
				if(powersetArray[i]) {
					for (int j = 0; j < powersetArray.length; j++) {
						if(powersetArray[j]) {
							teamCapabilities += synergyValue[i][j];
						}
					}
				}else {
					for (int j = 0; j < powersetArray.length; j++) {
						if(!powersetArray[j]) {
							anotherTeamCapabilities += synergyValue[i][j];
						}
					}
				}
			}
			if(teamCapabilities == 0) return;
			if(anotherTeamCapabilities == 0) return;
			int differenceTeams = teamCapabilities-anotherTeamCapabilities;
			if(differenceTeams < 0) differenceTeams*=-1;
			if(min > differenceTeams) min = differenceTeams;
			return;
		}
		powersetArray[nowIndex] = true;
		powerset(synergyValue ,powersetArray, nowIndex-1);
		powersetArray[nowIndex] = false;
		powerset(synergyValue, powersetArray, nowIndex-1);
	}
}
