import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        int flag = 1; // 1이 단어의 맨 앞임을 의미.
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                flag = 1;
                answer += " ";
            }else if(flag == 1){
                if(c >= 'a' && c <= 'z'){
                    answer += String.valueOf(c).toUpperCase();
                    flag = 0;
                }else{
                    answer += String.valueOf(c);
                    flag = 0;
                }
            }else{
                answer += String.valueOf(c).toLowerCase();
            }
        }
        
        return answer;
    }
}