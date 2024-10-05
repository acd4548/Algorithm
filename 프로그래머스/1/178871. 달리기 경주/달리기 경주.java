import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> m = new HashMap<>();
        for(int i = 0; i<players.length; i++){
            m.put(players[i], i);
        }
        
        for(int i = 0; i<callings.length; i++){
            int temp_idx = m.get(callings[i]);
            String temp_name = players[temp_idx];
            players[temp_idx] = players[temp_idx - 1];
            players[temp_idx - 1] = temp_name;
            
            m.put(players[temp_idx], temp_idx);
            m.put(players[temp_idx - 1], temp_idx - 1);
        }
        
        return players;
    }
}