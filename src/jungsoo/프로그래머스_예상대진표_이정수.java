package jungsoo;

public class 프로그래머스_예상대진표_이정수 {
	public int solution(int n, int a, int b)
    {
        int answer = 1;
        while(true){
            if(a%2==0 && b%2==1){
                if(a-1==b)
                    break;
            }
            if(b%2==0 && a%2==1){
                if(b-1==a)
                    break;
            }
            if(a%2 ==1)
                a=a+1;
            if(b%2 ==1)
                b=b+1;
            a/=2;
            b/=2;
            answer++;
        }
        return answer;
    }
}
