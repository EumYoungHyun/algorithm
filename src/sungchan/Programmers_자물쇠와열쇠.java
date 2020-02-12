package sungchan;

public class Programmers_자물쇠와열쇠 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{
					{0,0,0},
					{1,0,0},
					{0,1,1}
				},
				new int[][]{
					{1,1,1},
					{1,1,0},
					{1,0,1}
				}));
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
        
        boolean result = false;

        firstloop : for(int k=0; k<4; k++) {
            for(int i=0; i<key.length+lock.length; i++) {
                for(int j=0; j<key.length+lock.length; j++) {
                    int array[][] = new int[key.length*2+lock.length][key.length*2+lock.length];

                    for(int a=0; a<key.length; a++) {
                        for(int b=0; b<key.length; b++) {
                            array[a+i][b+j] += key[a][b];
                        }
                    }
                    
                    boolean ispossible = true;

                    secondloop : for(int a=0; a<lock.length; a++) {
                        for(int b=0; b<lock.length; b++) {
                            if(array[a+key.length][b+key.length] + lock[a][b] != 1) {
                                ispossible = false;
                                break secondloop;
                            }
                        }
                    }
                    
                    if(ispossible) {
                        result = true;
                        break firstloop;
                    }
                }
            }
            
            int temp[][] = new int[key.length][key.length];
            
            for(int i=0; i<temp.length; i++) {
                for(int j=0; j<temp.length; j++) {
                    temp[i][j] = key[key.length-j-1][i];
                }
            }
            
            for(int i=0; i<temp.length; i++) {
                for(int j=0; j<temp.length; j++) {
                    key[i][j] = temp[i][j];
                }
            }
        }
        
        return result;
    }
}
