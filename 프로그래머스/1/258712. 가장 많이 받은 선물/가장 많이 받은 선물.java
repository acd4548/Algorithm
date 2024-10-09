import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        //idx 저장
        HashMap<String, Integer> m = new HashMap<>();
        for(int i = 0; i<friends.length; i++){
            m.put(friends[i], i);
        }
        
        StringTokenizer st;
        int [][] info = new int [friends.length][friends.length];
        for(int i = 0; i<gifts.length; i++){
            st = new StringTokenizer(gifts[i]);
            String give = st.nextToken();
            String take = st.nextToken();
            
            info[m.get(give)][m.get(take)]++;
        }
        
        int [] count_give = new int [friends.length];
        int [] count_take = new int [friends.length];
        
        for(int i = 0; i<friends.length; i++){
            for(int j = 0; j<friends.length; j++){
                count_give[i] += info[i][j];
                count_take[i] += info[j][i];
            }
        }
        
        int answer = -1;
        int [] arr = new int [friends.length];
        for(int i = 0; i<friends.length - 1; i++){
            for(int j = i + 1; j<friends.length; j++){
                if(info[i][j] > info[j][i]){
                    arr[i]++;
                }else if(info[j][i] > info[i][j]){
                    arr[j]++;
                }else{
                    int t1 = count_give[i] - count_take[i];
                    int t2 = count_give[j] - count_take[j];
                    if(t1 > t2){
                        arr[i]++;
                    }else if(t2 > t1){
                        arr[j]++;
                    }
                }
            }
        }
        for(int i = 0; i<friends.length; i++){
            answer = Math.max(answer, arr[i]);
        }
        
        return answer;
    }
}