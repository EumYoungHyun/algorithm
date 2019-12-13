import java.util.*;
class 프로그래머스_섬연결하기_이정수 {
    
    class Land implements Comparable<Land>{
        int start;
        int end;
        int cost;
        
        public Land(int start, int end, int cost){
            this.start=start;
            this.end=end;
            this.cost=cost;
        }
        
        public int compareTo(Land l){
            return this.cost-l.cost;
        } 
    }
    int rank[];
    int p[];
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Land land[]=new Land[costs.length];
        for(int i=0;i<costs.length;i++)
            land[i]=new Land(costs[i][0],costs[i][1],costs[i][2]);
        Arrays.sort(land);
        rank=new int[n];
        p=new int[n];
        for(int i=0;i<n;i++){
            rank[i]=0;
            p[i]=i;
        }
        
        for(int i=0;i<land.length;i++){
            int x=land[i].start;
            int y=land[i].end;
            if(find(x)!=find(y)){
                union(x,y);
                answer+=land[i].cost;
            }
        }
        return answer;
    }
    
    public int find(int x){
        if(p[x]==x)
            return x;
        else{
            int px=find(p[x]);
            return px;
        }
    }
    
    public void union(int x, int y){
        int px=find(x);
        int py=find(y);
        if(rank[px]>rank[py]){
            p[py]=px;
        } else{
            p[px]=py;
            if(rank[px]==rank[py])
                rank[py]++;
        }
    }
}