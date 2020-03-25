package sungchan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Programmers_베스트앨범 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
	}
	
	public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalMap = new HashMap<String, Integer>();
        Map<String, PriorityQueue<Node>> sizeMap = new HashMap<String, PriorityQueue<Node>>();
        
        for(int i=0; i<genres.length; i++) {
            String genre = genres[i];
            if(totalMap.containsKey(genre)) {
                int size = totalMap.get(genre);
                totalMap.put(genre, size+plays[i]);
                
                PriorityQueue<Node> pqueue = sizeMap.get(genre);
                pqueue.add(new Node(plays[i], i));
                sizeMap.put(genre, pqueue);
            } else {
                totalMap.put(genre, plays[i]);
                
                PriorityQueue<Node> pqueue = new PriorityQueue<Node>(new Comparator<Node>() {
                   public int compare(Node o1, Node o2) {
                       return o2.size - o1.size;
                   } 
                });
                pqueue.add(new Node(plays[i], i));
                sizeMap.put(genre, pqueue);
            }
        }
        
        List<String> list = new ArrayList<String>(totalMap.keySet());
        Collections.sort(list, new Comparator<String>() {
           public int compare(String o1, String o2) {
               return totalMap.get(o2) - totalMap.get(o1);
           } 
        });
        
        List<Integer> tempResult = new ArrayList<Integer>();
        for(int i=0; i<list.size(); i++) {
            PriorityQueue<Node> pqueue = sizeMap.get(list.get(i));
            for(int j=0; j<2; j++) {
                if(pqueue.size() > 0) {
                    tempResult.add(pqueue.poll().index);
                }
            }
        }
        
        int result[] = new int[tempResult.size()];
        for(int i=0; i<tempResult.size(); i++) {
            result[i] = tempResult.get(i);
        }
        
        return result;
    }
    
    private static class Node {
        int size, index;
        public Node(int size, int index) {
            this.size = size;
            this.index = index;
        }
    }
}
