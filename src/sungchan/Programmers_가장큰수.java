package sungchan;

public class Programmers_가장큰수 {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{6,10,2}));
		System.out.println(solution(new int[]{3,30,34,5,9}));
	}
	
	public static String solution(int[] numbers) {
        quickSort(numbers, 0, numbers.length-1);
        
        StringBuilder sb = new StringBuilder();
        for(int i=numbers.length-1; i>=0; i--) {
            sb.append(numbers[i]);
        }
        
        if(sb.charAt(0) == '0') {
            return "0";
        } else {
            return sb.toString();
        }
    }
    
    public static void quickSort(int array[], int start, int end) {
        if(start >= end) {
            return;
        }
        
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot-1);
        quickSort(array, pivot+1, end);
    }
    
    public static int partition(int array[], int start, int end) {
        int p = start-1;
        
        firstloop : for(int i=start; i<end; i++) {
            String temp1 = array[end] + "" + array[i];
            String temp2 = array[i] + "" + array[end];
            
            for(int j=0; j<temp1.length(); j++) {
                if(temp1.charAt(j) > temp2.charAt(j)) {
                    p++;
                    int temp = array[p];
                    array[p] = array[i];
                    array[i] = temp;
                    continue firstloop;
                } else if(temp1.charAt(j) < temp2.charAt(j)) {
                    continue firstloop;
                }
            }
        }
        
        p++;
        int temp = array[p];
        array[p] = array[end];
        array[end] = temp;
        
        return p;
    }
}
