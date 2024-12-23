import java.util.*;
class Solution {
    public int solution(int n) {
        int [] arr = new int [100010];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i<100010; i++){
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567;
        }
        return arr[n];
    }
}