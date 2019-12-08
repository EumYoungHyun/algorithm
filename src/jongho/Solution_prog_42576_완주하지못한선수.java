package jongho;
import java.util.Arrays;
public class Solution_prog_42576_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        String answer = participant[completion.length];
        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                answer=participant[i];
                break;
            }
        }
        return answer;
    }
}
