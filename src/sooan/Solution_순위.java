package sooan;

/** 플로이드 와샬  */
public class Solution_순위 {
	public static void main(String[] args) {
		Solution_순위 s = new Solution_순위();
		int n = 5;
		int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
		s.solution(n, results);
	}
    public int solution(int n, int[][] results) {
        int answer = 0;
        int MAX = 10000000;
        int[][] G = new int[n+1][n+1];
        
        for (int i = 1; i < G.length; i++) {
			for (int j = 1; j < G.length; j++) {
				if(i==j) continue;
				G[i][j] = MAX;
			}
		}
        
        for(int i=0; i<results.length; i++){
            G[results[i][0]][results[i][1]] = 1;
        }
        for(int k=1; k<n+1; k++) {
        	for (int i = 1; i < n+1; i++) {
				for (int j = 1; j < n+1; j++) {
					
					if(G[i][j] > G[i][k] + G[k][j]) {
						G[i][j] = G[i][k] + G[k][j];
					}
				}
			}
		}
        boolean[] check = new boolean[n+1];
        
        for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				if(i!=j && G[i][j] == MAX && G[j][i] == MAX) {
					check[i] = true;
					break;
				}
			}
		}
        for(boolean c : check) {
        	if(!c) {
        		answer++;
        	}
		}
        return answer-1;
    }
}
