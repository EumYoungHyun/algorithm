package jongho;

import java.util.*;

public class Solution_prog_42747_H_Index {
	public static void main(String[] args) {
		int[] s = new int[] { 3,3,3,3,4 };
		System.out.println(solution(s));
	}

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            if (citations.length - i <= citations[i]) {
                answer = citations.length - i;
                break;
            }
        }
        return answer;
    }
}
