import java.util.*;
class Solution {
  public long solution(int a, int b) {
      long answer = 0;
      long abs= Math.abs(b-a);
      answer=(a+b)*((abs+1)/2);
      if(abs%2==0){
          answer+=((a+b)/2);
      }
      return answer;
  }
}