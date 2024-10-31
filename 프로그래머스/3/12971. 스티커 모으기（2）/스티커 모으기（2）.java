import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        int len = sticker.length;
        int [] dp1_used = new int [len];
        int [] dp1_unUsed = new int [len];
        int [] dp2_used = new int [len];
        int [] dp2_unUsed = new int [len];
        
        for(int i = 0; i<len; i++){
            dp1_used[i] = Math.max(dp1_used[(i + len - 2) % len], dp1_unUsed[(i + len - 2) % len]);
            dp1_used[i] = Math.max(dp1_used[i], dp2_unUsed[(i + len - 1) % len]);
            dp1_used[i] += sticker[i];
            
            dp1_unUsed[i] = Math.max(dp1_used[(i + len - 2) % len], dp1_unUsed[(i + len - 2) % len]);
            dp1_unUsed[i] = Math.max(dp1_unUsed[i], dp1_used[(i + len - 1) % len]);
            
            dp2_used[(i + len + 1) % len] = Math.max(dp2_used[(i + len - 1) % len], dp2_unUsed[(i + len - 1) % len]);
            dp2_used[(i + len + 1) % len] = Math.max(dp2_used[(i + len + 1) % len], dp2_unUsed[(i + len) % len]);
            dp2_used[(i + len + 1) % len] += sticker[(i + len + 1) % len];
            
            dp2_unUsed[(i + len + 1) % len] = Math.max(dp2_used[(i + len - 1) % len], dp2_unUsed[(i + len - 1) % len]);
            dp2_unUsed[(i + len + 1) % len] = Math.max(dp2_unUsed[(i + len + 1) % len], dp2_used[(i + len) % len]);
        }
        
        answer = Math.max(dp2_used[len - 1], dp1_unUsed[len - 1]);
        
        return answer;
    }
}