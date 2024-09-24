import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int [] score = new int [4];
        int idx = 1;
        int temp_score = 0;
        int temp_space = 0; // 1은S, 2은D, 3는T
        for(int i = 0; i<dartResult.length(); i++){
            if(dartResult.charAt(i) == 'S'){
                temp_space = 1;
                int temp = temp_score;
                for(int j = 0; j<temp_space-1; j++){
                    temp_score *= temp;
                }
                score[idx] = temp_score;
                if(i != dartResult.length() - 1){
                    i++;
                    if(dartResult.charAt(i) == '*'){
                        score[idx] *= 2;
                        score[idx-1] *= 2;
                    }else if(dartResult.charAt(i) == '#'){
                        score[idx] *= -1;
                    }else{
                        i--;
                    }
                }
                idx++;
                temp_score = 0;
            }else if(dartResult.charAt(i) == 'D'){
                temp_space = 2;
                int temp = temp_score;
                for(int j = 0; j<temp_space-1; j++){
                    temp_score *= temp;
                }
                score[idx] = temp_score;
                if(i != dartResult.length() - 1){
                    i++;
                    if(dartResult.charAt(i) == '*'){
                        score[idx] *= 2;
                        score[idx-1] *= 2;
                    }else if(dartResult.charAt(i) == '#'){
                        score[idx] *= -1;
                    }else{
                        i--;
                    }
                }
                idx++;
                temp_score = 0;
            }else if(dartResult.charAt(i) == 'T'){
                temp_space = 3;
                int temp = temp_score;
                for(int j = 0; j<temp_space-1; j++){
                    temp_score *= temp;
                }
                score[idx] = temp_score;
                if(i != dartResult.length() - 1){
                    i++;
                    if(dartResult.charAt(i) == '*'){
                        score[idx] *= 2;
                        score[idx-1] *= 2;
                    }else if(dartResult.charAt(i) == '#'){
                        score[idx] *= -1;
                    }else{
                        i--;
                    }
                }
                idx++;

                temp_score = 0;
            }else{
                if(temp_score == 0){
                    temp_score += dartResult.charAt(i) - '0';
                }else{
                    temp_score *= 10;
                    temp_score += dartResult.charAt(i) - '0';
                }
            }
            
        }
        for(int i = 1; i<4; i++){
            answer += score[i];
        }
        return answer;
    }
}