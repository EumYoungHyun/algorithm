package sungchan;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_다리를지나는트럭 {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int truck_weights[] = {7,4,5,6};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Node> queue = new LinkedList<Node>();
        
        int sum = 0;
        int time = 0;
        for(int i=0; i<truck_weights.length; i++) {
            int value = truck_weights[i];
            time++;
            
            while(!queue.isEmpty() && (sum+value > weight)) {
                Node node = queue.poll();
                sum = sum - node.value;
                
                int timedistance = time - node.time;
                int addtime = bridge_length-timedistance < 0 ? 0 : bridge_length-timedistance;
                time = time + addtime;
            }
            
            queue.add(new Node(value, time));
            sum = sum + value;
        }
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();

            int timedistance = time - node.time;
            int addtime = bridge_length-timedistance < 0 ? 0 : bridge_length-timedistance;
            time = time + addtime;
        }
        
        return time;
    }
}

class Node {
    int value, time;
    public Node(int value, int time) {
        this.value = value;
        this.time = time;
    }
}
