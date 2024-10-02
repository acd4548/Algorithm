import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char temp1 = '.';
        char temp2 = '.';
        Map <Character, Integer> m = new HashMap<>();
        m.put('R', 0);
        m.put('T', 0);
        m.put('C', 0);
        m.put('F', 0);
        m.put('J', 0);
        m.put('M', 0);
        m.put('A', 0);
        m.put('N', 0);
        
        for(int i = 0; i<survey.length; i++){
            temp1 = survey[i].charAt(0);
            temp2 = survey[i].charAt(1);
            
            int num = choices[i];
            if(num == 1){
                m.put(temp1, m.get(temp1) + 3);
            }else if(num == 2){
                m.put(temp1, m.get(temp1) + 2);
            }else if(num == 3){
                m.put(temp1, m.get(temp1) + 1);
            }else if(num == 5){
                m.put(temp2, m.get(temp2) + 1);
            }else if(num == 6){
                m.put(temp2, m.get(temp2) + 2);
            }else if(num == 7){
                m.put(temp2, m.get(temp2) + 3);
            }
        }
        
        int a = m.get('R');
        int b = m.get('T');
        if(a >= b){
            answer += "R";
        }else if(a < b){
            answer += "T";
        }
        
        a = m.get('C');
        b = m.get('F');
        if(a >= b){
            answer += "C";
        }else if(a < b){
            answer += "F";
        }
        
        a = m.get('J');
        b = m.get('M');
        if(a >= b){
            answer += "J";
        }else if(a < b){
            answer += "M";
        }
        
        a = m.get('A');
        b = m.get('N');
        if(a >= b){
            answer += "A";
        }else if(a < b){
            answer += "N";
        }
        
        return answer;
    }
    
    
}