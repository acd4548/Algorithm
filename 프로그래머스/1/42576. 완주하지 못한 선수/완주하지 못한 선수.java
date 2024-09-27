import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map <String, Integer> m = new HashMap<>();
        for(int i = 0; i<participant.length; i++){
            if(m.containsKey(participant[i])){
                m.put(participant[i], m.get(participant[i]) + 1);
            }else{
                m.put(participant[i], 1);
            }
        }
        
        for(int i = 0; i<completion.length; i++){
            if(m.get(completion[i]) == 1){
                m.remove(completion[i]);
            }else{
                m.put(completion[i], m.get(completion[i]) - 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        m.forEach((key, value) -> sb.append(key));
        String ans = sb.toString();
        return ans;
    }
}