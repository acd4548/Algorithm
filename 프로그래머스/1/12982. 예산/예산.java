import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int sum = 0;
        int idx = 0;
        while(true){
            if(idx < d.length && sum + d[idx] <= budget){
                answer++;
                sum += d[idx];
                idx++;
            }else{
                break;
            }
        }
        return answer;
    }
}