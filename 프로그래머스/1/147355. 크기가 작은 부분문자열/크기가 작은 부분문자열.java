import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int st = 0;
        int len = p.length();
        long p_num = Long.parseLong(p);
        for(int i = 0; i<=t.length() - len; i++){
            String str = t.substring(i, i + len);
            long temp = Long.parseLong(str);
            if(p_num >= temp){
                answer++;
            }
        }
        return answer;
    }
}