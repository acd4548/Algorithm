import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>(){
           @Override
            public int compare(int [] o1, int [] o2){
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });
        
        for(int i = 0; i<routes.length; i++){
            pq.offer(routes[i]);
        }
        
        int [] tempArr = pq.poll();
        int temp_0 = tempArr[0];
        int temp_1 = tempArr[1];
        while(!pq.isEmpty()){
            int [] next = pq.poll();
            if(temp_0 < next[0] && temp_1 > next[1]){
                temp_0 = next[0];
                temp_1 = next[1];
            }else if(temp_1 < next[0]){
                answer++;
                temp_0 = next[0];
                temp_1 = next[1];
            }else{
                continue;
            }
        }
        return answer;
    }
}