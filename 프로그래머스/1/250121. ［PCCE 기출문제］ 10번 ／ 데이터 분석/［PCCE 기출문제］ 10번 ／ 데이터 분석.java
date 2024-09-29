import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        // data code, date, maximum, remain

        int state = 0;
        if(ext.equals("code")){
            state = 0;
        }else if(ext.equals("date")){
            state = 1;
        }else if(ext.equals("maximum")){
            state = 2;
        }else if(ext.equals("remain")){
            state = 3;
        }
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<data.length; i++){
            int [] temp = data[i];
            if(temp[state] < val_ext){
                q.offer(temp);
            }
        }
        
        int size = q.size();
        int [][] answer = new int [size][4];
        for(int i = 0; i<size; i++){
            int temp [] = q.poll();
            answer[i][0] = temp[0];
            answer[i][1] = temp[1];
            answer[i][2] = temp[2];
            answer[i][3] = temp[3];
        }
        
        int sort_state = 0;
        if(sort_by.equals("code")){
            sort_state = 0;
        }else if(sort_by.equals("date")){
            sort_state = 1;
        }else if(sort_by.equals("maximum")){
            sort_state = 2;
        }else if(sort_by.equals("remain")){
            sort_state = 3;
        }
        
        int finalState = sort_state;
        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[finalState] - o2[finalState];  
            }
        });
        
        return answer;
    }
}