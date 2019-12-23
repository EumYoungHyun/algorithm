package jungsoo;

import java.util.HashSet;
public class 프로그래머스_폰켓몬_이정수 {
	public int solution(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums)
            set.add(i);
        int n=nums.length/2;
        if(set.size()>n)
            return n;
        else
            return set.size();
    }
}