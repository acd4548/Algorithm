class Solution {
    public int solution(String s) {
        int answer = 0;
        int same_cnt = 0;
        int dif_cnt = 0;
        char c = s.charAt(0);
        for(int i = 0; i<s.length(); i++){
            if(c == s.charAt(i)){
                same_cnt++;
            }else{
                dif_cnt++;
            }
            
            if(same_cnt == dif_cnt){
                answer++;
                same_cnt = 0;
                dif_cnt = 0;
                if(i < s.length() - 1){
                    c = s.charAt(i+1);
                }
            }
        }
        if(same_cnt > 0 || dif_cnt > 0){
            answer++;
        }
        return answer;
    }
}