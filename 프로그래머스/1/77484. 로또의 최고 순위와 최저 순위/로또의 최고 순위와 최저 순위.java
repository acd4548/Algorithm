class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int same_cnt = 0;
        int zero_cnt = 0;
        for(int i = 0; i<6; i++){
            for(int j = 0; j<6; j++){
                if(lottos[i] == win_nums[j]){
                    same_cnt++;
                }
            }
            
            if(lottos[i] == 0){
                zero_cnt++;
            }
        }
        int max = 6 - zero_cnt - same_cnt + 1;
        int min = 6 - same_cnt + 1;
        if(max >= 7){
            max = 6;
        }
        if(min >= 7){
            min = 6;
        }
        
        int answer [] = {max, min};
        return answer;
    }
}