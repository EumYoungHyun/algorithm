package sooan;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_다리를지나는트럭 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> wait = new LinkedList<>();
        Queue<Truck> onBridge = new LinkedList<>();
        int bridgeWeight = 0;
        
        for(int w : truck_weights) {
        	wait.add(new Truck(w, 0));
        }
        
        bridgeWeight += wait.peek().weight;
        onBridge.add(wait.poll());
        
        while(!onBridge.isEmpty()) {
        	answer++;
        	for(Truck t : onBridge) {
        		t.idx++;
        	}
        	if(onBridge.peek().idx > bridge_length) {
        		bridgeWeight -= onBridge.poll().weight;
        	}
        	if(!wait.isEmpty() && wait.peek().weight + bridgeWeight <= weight) {
        		bridgeWeight += wait.peek().weight;
        		wait.peek().idx++;
        		onBridge.add(wait.poll());
        	}
        }
        
        return answer;
    }
	public static class Truck {
		int weight;
		int idx;
		
		public Truck(int weight, int idx) {
			this.weight = weight;
			this.idx = idx;
		}
	}
}
