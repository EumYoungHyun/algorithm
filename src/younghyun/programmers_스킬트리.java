package younghyun;

public class programmers_스킬트리 {
    public static void main(String[] args) {
		programmers_스킬트리 s = new programmers_스킬트리();
		System.out.println(s.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
	}
	public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
label:  for(int i = 0; i < skill_trees.length; i++){
            String str =skill_trees[i];
            int idx = 0;
            for(int j = 0; j < str.length(); j++){
                if(skill.charAt(idx) == str.charAt(j)){
                    idx++;
                    if(idx == skill.length()) continue label;
                    continue;
                }
                for(int k = idx+1; k<skill.length(); k++){
                    if(skill.charAt(k) == str.charAt(j)){
                        answer--;
                        continue label;
                    }
                }
            }
        }
        return answer;
    }
}
