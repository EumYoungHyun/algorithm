package jungsoo;

public class 프로그래머스_시저암호_이정수 {
	public String solution(String s, int n) {
	      char ch[]=new char[s.length()];
	      int alpha[]=new int[s.length()];
	      String answer="";
	      
	      for(int i=0;i<s.length();i++){
	          ch[i]=s.charAt(i);
	          
	          if(ch[i]>='a' && ch[i]<='z'){
	              
	              if(ch[i]+n>'z')
	                  alpha[i]=ch[i]+n-26;
	              else
	                  alpha[i]=ch[i]+n;
	             }
	          
	          else if(ch[i]>='A' && ch[i]<='Z'){
	              if(ch[i]+n>'Z')
	                  alpha[i]=ch[i]+n-26;
	              else
	                  alpha[i]=ch[i]+n;
	          }
	          else if(ch[i]==' ')
	              alpha[i]=32;
	          
	          answer+=(char)alpha[i];
	              
	          
	      }
	      return answer;
	  }
}
