import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<ingredient.length; i++){
            if(s.size() < 3){
                s.add(ingredient[i]);
            }else if(ingredient[i] == 1){
                int ingre3 = s.pop();
                int ingre2 = s.pop();
                int ingre1 = s.pop();
                if(ingre1 == 1 && ingre2 == 2 && ingre3 == 3){
                    answer++;
                }else{
                    s.add(ingre1);
                    s.add(ingre2);
                    s.add(ingre3);
                    s.add(ingredient[i]);
                }
            }else{
                s.add(ingredient[i]);
            }
        }
        return answer;
    }
}