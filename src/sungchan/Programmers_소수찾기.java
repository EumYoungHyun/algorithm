package sungchan;

public class Programmers_소수찾기 {
	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}
	
	static int count;
	static boolean visited[];
	
	public static int solution(String numbers) {
		count = 0;
		visited = new boolean[10000000];
		
		for(int i=0; i<(1 << numbers.length()); i++) {
			String result = "";
			
			for(int j=0; j<numbers.length(); j++) {
				if((i & (1 << j)) != 0) {
					result = result + numbers.charAt(j);
				}
			}
			
			if(!result.equals("")) {
				makeP(result.toCharArray(), 0);
			}
		}
		
		return count;
	}
	
	public static void makeP(char array[], int index) {
		if(index >= array.length) {
			String temp = "";
			for(int i=0; i<array.length; i++) {
				temp = temp + array[i];
			}
			
			int value = Integer.valueOf(temp);
			
			if(!visited[value] && isPrime(value)) {
				visited[value] = true;
				count++;
			}
			
			return;
		}
		
		for(int i=index; i<array.length; i++) {
			char temp = array[i];
			array[i] = array[index];
			array[index] = temp;
			
			makeP(array, index+1);
			
			temp = array[i];
			array[i] = array[index];
			array[index] = temp;
		}
	}
	
	public static boolean isPrime(int value) {
		if(value <= 1) {
			return false;
		}
		
		for(int i=2; i<value/2; i++) {
			if(value % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
