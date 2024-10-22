import java.util.*;
class Solution{
    public int solution(int n, int a, int b)    {
        int answer = 0;
        
        int clone_n = n;
        while(clone_n > 1){
            answer++;
            clone_n /= 2;
        }
        
        int st = 1;
        int ed = n;
        while(st <= ed){
            int temp = (st + ed) / 2;
            if(a <= temp && b <= temp){
                ed = temp;
                answer--;
            }else if(a > temp && b > temp){
                st = temp + 1;
                answer--;
            }else if(answer == 1){
                return answer;
            }else{
                break;
            }
        }
        return answer;
    }
}