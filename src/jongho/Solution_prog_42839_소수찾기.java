package jongho;
import java.util.*;

public class Solution_prog_42839_소수찾기 {	// powerSet 후 perm, int로 변환, 소수 판별
	public static String str;
	public static boolean[] chk, chks;
	public static char[] tempStr;
	public static int answer;
	public static void main(String[] args) {
		System.out.println(solution("1172"));
	}
    public static int solution(String numbers) {
        answer = 0;
        str=numbers;
		chk=new boolean[str.length()];
		chks=new boolean[(int)Math.pow(10, str.length())];
        powerSet(0);
        
        return answer;
    }
    public static void powerSet(int k) {
    	if(k==str.length()) {
    		String s = "";
    		for(int i=0; i<str.length();i++) {
    			if(chk[i]) s+=str.charAt(i);
    		}
    		tempStr=new char[s.length()];
    		for(int i=0; i<s.length(); i++) {
    			tempStr[i]=s.charAt(i);
    		}
    		perm(0,tempStr.length);
    		
    		return;
    	}
    	chk[k]=false;
    	powerSet(k+1);
    	chk[k]=true;
    	powerSet(k+1);
    }
    
    public static void perm(int k,int n){
    	if(n==k) {
    		String s = "";
    		for(int i=0; i<n; i++) {
    			s+=(""+tempStr[i]);
    		}
    		if(s.equals("")) return;
    		
    		isPrime(Integer.parseInt(s));
    	}else {
    		for(int i=k; i<n; i++) {
    			char temp=tempStr[i];
    			tempStr[i]=tempStr[k];
    			tempStr[k]=temp;
    			perm(k+1,n);
    			temp=tempStr[i];
    			tempStr[i]=tempStr[k];
    			tempStr[k]=temp;    			
    		}
    	}
    }
    public static void isPrime(int m) {
		if(m<2 || chks[m]) return;
		chks[m]=true;
		int j;
		for(j=2; j*j<=m; j++) {
			if(m%j==0) {
				return;
			}
		}
		System.out.print(m +" ");
		answer++; 
    }
}
