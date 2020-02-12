package sungchan;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers_단속카메라 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{-20,15},{-14,-5},{-18,-13},{-5,-3}}));
	}
	
	public static int solution(int[][] routes) {
		class Node {
		    int start;
		    int end;
		    public Node(int start, int end) {
		        this.start = start;
		        this.end = end;
		    }
		}
		
        PriorityQueue<Node> pqueue = new PriorityQueue<Node>(new Comparator<Node>() {
           public int compare(Node o1, Node o2) {
               return o1.end - o2.end;
           } 
        });
        
        for(int i=0; i<routes.length; i++) {
            pqueue.add(new Node(routes[i][0], routes[i][1]));
        }
        
        int count = 0;
        
        while(!pqueue.isEmpty()) {
            Node node = pqueue.poll();
            count++;
            
            while(!pqueue.isEmpty()) {
                Node temp = pqueue.peek();
                if(temp.start <= node.end) {
                    pqueue.poll();
                } else {
                    break;
                }
            }
        }
        
        return count;
    }
}
