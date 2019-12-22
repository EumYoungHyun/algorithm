package jongho;
import java.util.*;

//DFS,BFS
public class Solution_prog_43165_타겟넘버 {
	public static void main(String[] args) {
		int[]numbers = new int[] {1,1,1,1,1};
		System.out.println(solution(numbers, 3));
	}
    public static char[] op;
    public static int answer = 0;
    public static int solution(int[] numbers, int target) {
        op = new char[]{'+','-'};
        dfs(numbers,0, target, 0, 'A');
        return answer;
    }
    public static void dfs(int[] numbers, int n, int target, int sum, int ops){
        if(n!=0){
            sum += Integer.parseInt(""+op[ops]+numbers[n-1]);
        }
        if(n==numbers.length){ 
            if(sum==target) answer++; 
            return; 
        }
        for(int i=0; i<op.length; i++){
            dfs(numbers, n+1, target, sum, i);
        }
    }
}