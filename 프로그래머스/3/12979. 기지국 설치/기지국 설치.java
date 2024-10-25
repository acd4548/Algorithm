class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = w * 2 + 1;
        int st = 1;
        int idx = 0;
        int len = stations.length;
        while(idx < len){
            if(st >= stations[idx] - w){
                st = stations[idx] + w + 1;
                idx++;
            }else{
                int temp = stations[idx] - w;
                answer += (temp - st) / range;
                if((temp - st) % range != 0){
                    answer++;
                }
                st = stations[idx] + w + 1;
                idx++;
            }
        }
        
        if(st <= n){
            answer += (n - st + 1) / range;
            if((n - st + 1) % range != 0){
                answer++;
            }
        }

        return answer;
    }
}