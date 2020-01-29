package sungchan;

public class Programmers_괄호변환 {
	public static void main(String[] args) {
		 System.out.println(solution("(()())()"));
		 System.out.println(solution(")("));
		 System.out.println(solution("()))((()"));
	}
	
	public static String solution(String p) {
        return solve(p);
    }
    
    public static String solve(String p) {
        if(p.equals("")) {
            return "";
        }
        
        int left = 0;
        int right = 0;
        boolean check = false;

        for(int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if(left == right) {
                String u = p.substring(0, i+1);
                String v = p.substring(i+1);
                
                if(check) {
                    String temp = "(";
                    temp = temp + solve(v);
                    temp = temp + ")";
                    
                    for(int j=1; j<u.length()-1; j++) {
                        if(u.charAt(j) == '(') {
                            temp = temp + ')';
                        } else {
                            temp = temp + '(';
                        }
                    }
                    
                    return temp;
                } else {
                    return u + solve(v);
                }
            }

            if(right > left) {
                check = true;
            }
        }
        
        return p;
    }
}
