package jungsoo;

public class 프로그래머스_서머코딩윈터코딩2018_소수만들기_이정수 {
	public int solution(int[] nums) {
        int answer = 0;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int sum=nums[i]+nums[j]+nums[k];
                    boolean flag=false;
                    for(int t=2;t<=Math.sqrt(sum);t++){
                        if(sum%t==0){
                            flag=true;
                            break;
                        }
                    }
                    if(!flag){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}