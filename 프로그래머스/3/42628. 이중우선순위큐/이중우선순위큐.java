import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int [2];
        TreeMap<Integer, Integer> m = new TreeMap<>();
        StringTokenizer st;
        for(int i = 0; i<operations.length; i++){
            st = new StringTokenizer(operations[i]);
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            if(str.equals("I")){
                m.put(num, m.getOrDefault(num, 0) + 1);
            }else{
                if(m.isEmpty()) continue;
                if(num == -1){
                    if(m.get(m.firstKey()) == 1){
                        m.remove(m.firstKey());
                    }else{
                        m.put(m.firstKey(), m.get(m.firstKey()) - 1);
                    }
                }else{
                    if(m.get(m.lastKey()) == 1){
                        m.remove(m.lastKey());
                    }else{
                        m.put(m.lastKey(), m.get(m.lastKey()) - 1);
                    }
                }
            }
        }
        
        if(!m.isEmpty()){
            answer[0] = m.lastKey();
            answer[1] = m.firstKey();
        }
        return answer;
    }
}