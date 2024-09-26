import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        int [] arr = new int [26];
        char [] cArr = new char [26];
        for(int i = 0; i<26; i++){
            cArr[i] = (char)('a' + i);
        }
        
        for(int i = 0; i<skip.length(); i++){
            arr[skip.charAt(i) - 'a'] = 1;
        }
        
        int go_cnt = 0;
        int idx = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            go_cnt = 0;
            idx = c - 'a';
            while(true){
                go_cnt++;
                idx++;
                idx %= 26;
                if(arr[idx] == 1){
                    go_cnt--;
                }
                
                if(go_cnt == index){
                    answer += Character.toString(cArr[idx]);
                    break;
                }
            }
        }
        
        return answer;
    }
}