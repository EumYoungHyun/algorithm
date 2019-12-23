package jongho;
import java.util.*;

//DFS,BFS
public class Solution_prog_43237_예산 {
	public static void main(String[] args) {
		int[] budgets = new int[] {120,110,140,150};
		System.out.println((solution(budgets,485)));
	}
    public static int solution(int[] budgets, int M) {
        int answer = 0;
        int left = 0;
        int right = 0;
        for (int budget : budgets) {
            if (budget > right) {
                right = budget;
            }
        }
        int middle = 0;
        while (left <= right) {
            long sum = 0;
            middle = (left + right) / 2;
            for (int budget : budgets) {
                if (budget >= middle) {
                    sum += middle;
                }
                else {
                    sum += budget;
                }
            }
            if (sum > M) {
                right = middle - 1;
            }
            else {
                answer = middle;
                left = middle + 1;
            }
        }
        return answer;
    }
}