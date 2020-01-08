package sungchan;

public class Programmers_스킬트리 {
	public static void main(String[] args) {
		String skill = "CBD";
		String skill_trees[] = {"BACDE", "CBADF", "AECB", "BDA"};
		
		System.out.println(solution(skill, skill_trees));
	}
	
	public static int solution(String skill, String[] skill_trees) {
        int array[] = new int[26];
        
        for(int i=0; i<skill.length(); i++) {
            array[skill.charAt(i)-'A'] = i+1;
        }
        
        int count = 0;
        firstloop : for(int i=0; i<skill_trees.length; i++) {
            String target = skill_trees[i];
            int level = 0;
            for(int j=0; j<target.length(); j++) {
                int temp = target.charAt(j)-'A';
                if(array[temp] != 0) {
                    if(level > array[temp] || array[temp] != level+1) {
                        continue firstloop;
                    }
                    
                    level++;
                }
            }
            
            count++;
        }
        
        return count;
    }
}
