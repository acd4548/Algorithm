import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int [targets.length];
        char [] cArr = new char [26];
        int [] minClickCnt = new int [26];
        Arrays.fill(minClickCnt, 20000);
        for(int i = 0; i<26; i++){
            cArr[i] = (char) ('A' + i);
        }
        
        for(int i = 0; i<keymap.length; i++){
            for(int j = 0; j<keymap[i].length(); j++){
                char c = keymap[i].charAt(j);
                int idx = c - 'A';
                minClickCnt[idx] = Math.min(j + 1, minClickCnt[idx]);
            }
        }
        
        for(int i = 0; i<targets.length; i++){
            int cnt = 0;
            for(int j = 0; j<targets[i].length(); j++){
                int idx = targets[i].charAt(j) - 'A';
                cnt += minClickCnt[idx];
            }
            if(cnt >= 20000){
                answer[i] = -1;
            }else{
                answer[i] = cnt;
            }
        }
        
        return answer;
    }
}