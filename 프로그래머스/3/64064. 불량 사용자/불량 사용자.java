import java.util.*;
class Solution {
    static int user_visited[];
    static int ban_visited[];
    static String [] user;
    static String [] banned;
    static int answer;
    static HashSet<String> s = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        user_visited = new int [user_id.length];
        ban_visited = new int [banned_id.length];
        user = user_id;
        banned = banned_id;
        
        recur(0);
        return s.size();
    }
    
    private static void recur(int cur){
        if(cur == ban_visited.length){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<user_visited.length; i++){
                sb.append(user_visited[i]);
            }
            
            s.add(sb.toString());
            return;
        }
        
        for(int i = 0; i<user_visited.length; i++){
            if(user_visited[i] == 0 && check(cur, i)){
                user_visited[i] = 1;
                // System.out.println(Arrays.toString(user_visited));
                recur(cur + 1);
                user_visited[i] = 0;
            }
        }
    }
    
    private static boolean check(int cur, int idx){
        // System.out.println(cur + " " + idx);
        if(banned[cur].length() != user[idx].length()) return false;
        
        for(int i = 0; i<banned[cur].length(); i++){
            char ban_c = banned[cur].charAt(i);
            char user_c = user[idx].charAt(i);
            // System.out.println(ban_c + " " + user_c);
            if(user_c != ban_c && ban_c != '*'){
                
                return false;
            }
        }
            // System.out.println(1);
        return true;
    }
}