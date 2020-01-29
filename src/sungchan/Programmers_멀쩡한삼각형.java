package sungchan;

public class Programmers_멀쩡한삼각형 {
	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		System.out.println(solution(w, h));
	}
	
	public static long solution(int w,int h) {
		if(w > h) {
            int temp = w;
            w = h;
            h = temp;
        }
        
		long result = ((long)w*h) - (w+h-GCD(h, w));
        return result;
	}
    
    public static int GCD(int a, int b) {
        if(a%b == 0) {
            return b;
        } else {
            return GCD(b, a%b);
        }
    }
}
