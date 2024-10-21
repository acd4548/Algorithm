import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toBinaryString(n);
        int cnt_1 = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '1'){
                cnt_1++;
            }
        }
        
        int temp = n + 1;
        while(true){
            String str_temp = Integer.toBinaryString(temp);
            int cnt_temp = 0;
            for(int i = 0; i<str_temp.length(); i++){
                if(str_temp.charAt(i) == '1'){
                    cnt_temp++;
                }
            }
            if(cnt_temp == cnt_1){
                return temp;
            }else{
                temp ++;
            }
        }
    }
}