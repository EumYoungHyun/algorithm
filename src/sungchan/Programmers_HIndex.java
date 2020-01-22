package sungchan;

public class Programmers_HIndex {
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3,0,6,1,5}));
	}
	
	public static int solution(int[] citations) {
        quickSort(citations, 0, citations.length-1);
        
        int result = 0;
        for(int h=0; h<=citations.length; h++) {
            for(int i=0; i<citations.length; i++) {
                if(citations[i] >= h) {
                    int upper = citations.length-i; // h번 이상 인용된 논문의 갯수
                    int lower = i; // h번 미만 인용된 논문의 갯수
                    
                    if(upper >= h && lower <= h) {
                        result = h;
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void quickSort(int array[], int start, int end) {
        if(start > end) {
            return;
        }
        
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot-1);
        quickSort(array, pivot+1, end);
    }
    
    public static int partition(int array[], int start, int end) {
        int p = start-1;
        
        for(int i=start; i<end; i++) {
            if(array[end] > array[i]) {
                int temp = array[++p];
                array[p] = array[i];
                array[i] = temp;
            }
        }
        
        int temp = array[++p];
        array[p] = array[end];
        array[end] = temp;
        
        return p;
    }
}
