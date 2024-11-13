import java.util.*;
class Solution {
    static ArrayList<Integer>list[];
    static int [] visited;
    static int [] len;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        list = new ArrayList[n+1];
        visited = new int [n+1];
        len = new int [n+1];
        
        for(int i = 1; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i<edge.length; i++){
            int [] temp = edge[i];
            list[temp[0]].add(temp[1]);
            list[temp[1]].add(temp[0]);
        }
        
        bfs();
        
        for(int i = n; i>0; i--){
            if(len[i] != 0){
                answer = len[i];
                break;
            }
        }
        return answer;
    }
    
    private static void bfs(){
        visited[1] = 1;
        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {1, 0});
        
        while(!q.isEmpty()){
            int [] temp = q.poll();
            
            for(int i = 0; i<list[temp[0]].size(); i++){
                if(visited[list[temp[0]].get(i)] == 1) continue;
                
                len[temp[1] + 1]++;
                visited[list[temp[0]].get(i)] = 1;
                q.offer(new int [] {list[temp[0]].get(i), temp[1] + 1});
            }
        }
    }
}