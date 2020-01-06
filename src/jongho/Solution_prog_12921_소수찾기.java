package jongho;

// calc, prime
public class Solution_prog_12921_소수찾기 {
	public static void main(String[] args) {
		System.out.println(solution(1000000));
	} 
	public static int solution(int n) {
	      int answer = 0;
	      boolean[] primes = new boolean[n+1];  // true이면 소수가 아닌 것
	      for(int i=2; i<=n; i++){
	          if(primes[i]) continue;
	          answer++;
	          for(int j=i, k=2; j<=n; j=(i*k++)){
	              primes[j]=true;
	          }
	      }   
	      return answer;
	  }
}