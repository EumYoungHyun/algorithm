package sungchan;
import java.util.ArrayList;
import java.util.List;

public class Programmers_순위 {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
	}
	
	static List<Integer> upList[];
    static List<Integer> downList[];
    static boolean visited[];
    public static int solution(int n, int[][] results) {
        upList = new List[n+1];
        downList = new List[n+1];
        int result = 0;
        
        for(int i=1; i<=n; i++) {
            upList[i] = new ArrayList<Integer>();
            downList[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<results.length; i++) {
            downList[results[i][0]].add(results[i][1]);
            upList[results[i][1]].add(results[i][0]);
        }
        
        for(int i=1; i<=n; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            solve(i, true); // true = up
            solve(i ,false); // false = down
            
            for(int j=1; j<=n; j++) {
                if(visited[j] == false) {
                    break;
                }
                
                if(j == n) {
                    result++;
                }
            }
        }
        
        return result;
    }
    
    public static void solve(int index, boolean check) {
        if(check) {
            for(int i=0; i<upList[index].size(); i++) {
                if(!visited[upList[index].get(i)]) {
                    visited[upList[index].get(i)] = true;
                    solve(upList[index].get(i), check);
                }
            }
        } else {
            for(int i=0; i<downList[index].size(); i++) {
                if(!visited[downList[index].get(i)]) {
                    visited[downList[index].get(i)] = true;
                    solve(downList[index].get(i), check);
                }
            }
        }
    }
}
