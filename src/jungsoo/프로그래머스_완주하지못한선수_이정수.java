package ���α׷��ӽ�;
import java.util.Arrays;
import java.util.HashMap;
public class ���α׷��ӽ�_�����������Ѽ���_������ {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        boolean check=false;
        HashMap<Integer,String> par=new HashMap<>();
        HashMap<Integer,String> com=new HashMap<>();
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0;i<completion.length;i++) {
        	par.put(i,participant[i]); //(��ȣ, �������̸�)
        	com.put(i,completion[i]);
        	
        	if(!par.get(i).equals(com.get(i))) {
        		answer=par.get(i);
        		check=true;
        		break;
        	}
        	else {
        		check=false;
        	}
        }
        
        if(check==false) {
        	answer=participant[participant.length-1];
        }
        return answer;
    }

}
