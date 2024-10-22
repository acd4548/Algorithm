import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i<tangerine.length; i++){
            if(!m.containsKey(tangerine[i])){
                m.put(tangerine[i], 1);
            }else{
                m.put(tangerine[i], m.get(tangerine[i]) + 1);
            }
        }
        
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] != o2[1]){
                    return o2[1] - o1[1];
                }else{
                    return o2[0] - o1[0];
                }
            }
        });
        for(int key : m.keySet()){
            int [] temp = {key, m.get(key)};
            pq.offer(temp);
        }
        
        int cnt = 0;
        while(cnt < k){
            int [] temp = pq.poll();
            cnt += temp[1];
            answer++;
        }
        return answer;
    }
}