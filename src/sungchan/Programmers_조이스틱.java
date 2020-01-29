package sungchan;

public class Programmers_조이스틱 {
	public static void main(String[] args) {
		System.out.println(solution("JEROEN"));
		System.out.println(solution("JAN"));
		System.out.println(solution("BBAABB"));
	}
	
	public static int solution(String name) {
		int count = 0;
        int curindex = 0;
        
        while(true) {
            if(name.charAt(curindex) >= 'A' && name.charAt(curindex) <= 'N') {
                count = count + (name.charAt(curindex) - 'A');
            } else {
                count = count + ('Z' - name.charAt(curindex) +1);
            }
            
            name = name.substring(0, curindex) + 'A' + name.substring(curindex+1);
            
            int leftindex = curindex, leftcount = 0;
            int rightindex = curindex, rightcount = 0;
            
            for(; leftcount != name.length();) {
                leftindex--;
                leftindex = (leftindex+name.length()) % name.length();
                leftcount++;
                
                if(name.charAt(leftindex) != 'A') {
                    break;
                }
            }
            
            for(; rightcount != name.length();) {
                rightindex++;
                rightindex = rightindex % name.length();
                rightcount++;
                
                if(name.charAt(rightindex) != 'A') {
                    break;
                }
            }
            
            if(leftcount == name.length() && rightcount == name.length()) {
                break;
            } else if(leftcount >= rightcount) {
                count = count + rightcount;
                curindex = rightindex;
            } else {
                count = count + leftcount;
                curindex = leftindex;
            }
        }
        
        return count;
    }
}
