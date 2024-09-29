import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int arrX [] = new int [10];
        int arrY [] = new int [10];
        int double_used [] = new int [10];
        
        for(int i = 0; i<X.length(); i++){
            int num = X.charAt(i) - '0';
            arrX[num]++;
        }
        
        for(int i = 0; i<Y.length(); i++){
            int num = Y.charAt(i) - '0';
            arrY[num]++;
        }
        
        int temp = 0;
        for(int i = 0; i<10; i++){
            double_used[i] = Math.min(arrX[i], arrY[i]);
            temp += double_used[i];
        }
        
        if(temp == 0){
            sb.append("-1");
        }else{
            for(int i = 9; i>=0; i--){
                if(sb.length() == 0 && i == 0){
                    sb.append("0");
                    break;
                }
                
                while(double_used[i] > 0){
                    sb.append(i);
                    double_used[i] --;
                }
            }
        }
        String answer = sb.toString();
        return answer;
    }
}