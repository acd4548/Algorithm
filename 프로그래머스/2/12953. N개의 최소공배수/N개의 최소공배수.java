import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int temp = arr[arr.length - 1];
        int flag = 1;
        while(true){
            flag = 1;
            for(int i = 0; i<arr.length - 1; i++){
                if(temp % arr[i] != 0){
                    flag = 0;
                    break;
                }
            }
            
            if(flag == 0){
                temp += arr[arr.length - 1];
            }else{
                answer = temp;
                break;
            }
        }
        return answer;
    }
}