package younghyun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890_경사로 {
	static int n,l, cnt;
    static int[][] map;
    
	public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            if(solve(map[i])) cnt++;
            
            int[] temp = new int[n];
            
            for (int j = 0; j < n; j++) {
                temp[j] = map[j][i];
            }
            if(solve(temp)) cnt++;
        }
        
        System.out.println(cnt);
    }
	static boolean solve(int[] arr) {
        int idx = 0;
        boolean[] visited = new boolean[n];
        
        while(true) {
            // 끝까지 도달.
            if(idx == n-1) break;
            
            // 내려가는 경사로인 경우
            if(arr[idx+1] == arr[idx] - 1) {
                if(idx + l >= n ) return false;
                
                for (int i = idx+1; i <= idx+l; i++) {
                    visited[i] = true;
                    if(arr[i] != arr[idx] -1)
                        return false;
                }
                idx += l;
            }
            // 올라가는 경사로인 경우
            else if(arr[idx+1] == arr[idx] + 1) {
                if( idx - (l-1) < 0 ) return false;
                
                for (int i = idx-(l-1); i <= idx; i++) {
                    if(visited[i] || arr[i] != arr[idx])
                        return false;
                }
                idx++;
            }
            // 평지인 경우
            else if(arr[idx] == arr[idx+1]) {
                idx++;
            }
            // 높이 차이가 2 이상인 경우, 못지나감.
            else {
                return false;
            }
        }
        return true;
    }
}
