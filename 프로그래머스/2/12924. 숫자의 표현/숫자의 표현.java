class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 1;
        int st = 1;
        int ed = 1;
        while(st != ed || st != n){
            if(sum < n){
                ed += 1;
                sum += ed;
            }else if(sum > n){
                sum -= st;
                st += 1;
            }else{
                answer++;
                ed += 1;
                sum += ed;
            }
        }
        return answer + 1;
    }
}