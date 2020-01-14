package sungchan;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers_N으로표현 {
	public static void main(String[] args) {
		System.out.println(solution(5, 12));
		System.out.println(solution(2, 11));
		System.out.println(solution(5, 31168));
	}
	
	public static int solution(int N, int number) {
        int values[] = new int[8];
        int value = N;
        for(int i=1; i<values.length; i++) {
            values[i] = value;
            value = value*10 + N;
        }
        
        int result = 9;
        
        PriorityQueue<Node> pqueue = new PriorityQueue<Node>(new Comparator<Node>() {
           public int compare(Node o1, Node o2) {
               return o1.count - o2.count;
           } 
        });
        
        pqueue.add(new Node(0, 0));
        
        while(!pqueue.isEmpty()) {
            Node node = pqueue.poll();
            
            if(node.count > 8)
            	break;
            
            if(node.value == number) {
                result = node.count;
                break;
            }
            
            for(int i=1; i<values.length; i++) {
                pqueue.add(new Node(node.value+values[i], node.count+i));
                pqueue.add(new Node(node.value-values[i], node.count+i));
                pqueue.add(new Node(node.value*values[i], node.count+i));
                pqueue.add(new Node(node.value/values[i], node.count+i));
            }
        }
        
        if(result > 8)
            result = -1;
        
        return result;
    }
	
	private static class Node {
	    int value, count;
	    public Node(int value, int count) {
	        this.value = value;
	        this.count = count;
	    }
	}
}
