package jongho;

import java.util.*;

public class Solution_prog_42746_가장큰수 {
	public static void main(String[] args) {
		int[] s2 = new int[] { 6, 10, 2 };
		System.out.println(solution(s2));
	}

    public static String solution(int[] numbers) {
        String answer = "";
        String[] numStr = new String[numbers.length];
        numToNum[] numToNums = new numToNum[numbers.length];
        int maxSize = 0;
        for(int i=0; i<numStr.length; i++){
            numStr[i] = Integer.toString(numbers[i]);
            maxSize=Math.max(maxSize,numStr[i].length());
        }
        for(int i=0; i<numStr.length; i++){
            int n = maxSize-numStr[i].length();
            if(n>0){
                for(int j=0; j<n; j++){
                    int tempj=j;
                    if(j>=numStr[i].length()){
                        tempj%=numStr[i].length();
                    }numStr[i]+=numStr[i].charAt(tempj);
                }
            }
            numToNums[i]=new numToNum(numbers[i],Integer.parseInt(numStr[i]));
        }
        System.out.println("numToNums : "+Arrays.toString(numToNums));
        Arrays.sort(numToNums, new Comparator<numToNum>() {
			@Override
			public int compare(numToNum o1, numToNum o2) {
				return o2.change-o1.change;
			}
		});
        for(int i=0; i<numToNums.length; i++) {
        	answer=answer+numToNums[i].origin;
        }
        return answer;
    }
    public static class numToNum{
        int origin;
        int change;
        public numToNum(int origin, int change){
            this.origin=origin; this.change=change;
        }
    }
}
