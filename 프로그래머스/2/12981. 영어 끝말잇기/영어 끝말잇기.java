import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int [2];;
        HashSet<String> s = new HashSet<>();
        int cnt = 1;
        answer[1] = 1;
        int flag = 1;
        int temp_c = '.';
        for(int i = 0; i<words.length; i++){
            String str = words[i];
            if(s.contains(str) || ((i != 0) && str.charAt(0) != temp_c)){
                answer[0] = cnt;
                flag = 0;
                break;
            }else{
                cnt++;
                if(cnt > n){
                    cnt = 1;
                    answer[1]++;
                }
                temp_c = str.charAt(str.length() - 1);
                s.add(str);
            }
        }
        
        if(flag == 1){
            answer[0] = 0;
            answer[1] = 0;
        }
        
        return answer;
    }
}