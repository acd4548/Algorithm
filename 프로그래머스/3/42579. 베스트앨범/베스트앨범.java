import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> idx_m = new HashMap<>();
        int idx = 0;
        for(int i = 0; i<genres.length; i++){
            if(!idx_m.containsKey(genres[i])){
                idx_m.put(genres[i], idx++);
            }
        }
        
        int [] arr = new int [idx];
        ArrayList <int[]> [] list = new ArrayList[idx];
        for(int i = 0; i<idx; i++){
            list[i] = new ArrayList<int[]>();
        }
        
        for(int i = 0; i<genres.length; i++){
            int temp_idx = idx_m.get(genres[i]);
            arr[temp_idx] += plays[i];
            list[temp_idx].add(new int [] {i, plays[i]});
        }
        
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int[]>(){
           @Override
            public int compare(int [] o1, int [] o2){
                return o2[1] - o1[1];
            }
        });
        
        for(int i = 0; i<idx; i++){
            Collections.sort(list[i], new Comparator<int[]>(){
                @Override
                public int compare(int [] o1, int [] o2){
                    if(o1[1] != o2[1]){
                        return o2[1] - o1[1];
                    }else{
                        return o1[0] - o2[0];
                    }
                }
            });
            
            pq.offer(new int [] {i, arr[i]});
        }
        
        Queue<Integer> q = new LinkedList<>();
        while(!pq.isEmpty()){
            int temp [] = pq.poll();
            for(int i = 0; i<2; i++){
                if(list[temp[0]].size() <= i) break;
                q.offer(list[temp[0]].get(i)[0]);
            }
        }
        
        int size = q.size();
        int [] answer = new int [size];
        for(int i = 0; i<size; i++){
            answer[i] = q.poll();
        }
        return answer;
    }
}