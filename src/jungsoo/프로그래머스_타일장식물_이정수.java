package jungsoo;

public class 프로그래머스_타일장식물_이정수 {
	public long solution(int N) {
        long answer = 0;
        if(N==1)
            return 4;
        long num1=1;
        long num2=1;
        long result=0;
        for(int i=1;i<N;i++){
            result=num1+num2;
            num1=num2;
            num2=result;
        }
        answer=result*2+num1*2;
        return answer;
    }
}
