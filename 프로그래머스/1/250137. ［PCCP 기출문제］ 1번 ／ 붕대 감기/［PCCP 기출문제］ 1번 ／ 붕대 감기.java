class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int st_health = health;
        //bandage [0] 시전시간, [1] 1초당 회복량, [2] 추가 회복량
        int max_time = attacks[attacks.length-1][0];
        int attacks_idx = 0;
        int continue_heal = 0;
        for(int i = 1; i<=max_time; i++){
            if(attacks[attacks_idx][0] == i){
                continue_heal = 0;
                health -= attacks[attacks_idx][1];
                if(health <= 0){
                    return -1;
                }
                attacks_idx++;
            }else{
                health += bandage[1];
                continue_heal++;
                if(continue_heal == bandage[0]){
                    continue_heal = 0;
                    health += bandage[2];
                }
                
                if(health > st_health){
                    health = st_health;
                }
            }
        }
        return health;
    }
}