import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int left_location = 10;
        int right_location = 11;
        
        int [] two_dis = {3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 4};
        int [] five_dis = {2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 3};
        int [] eight_dis = {1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 2};
        int [] zero_dis = {0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 1};
        
        for(int i = 0; i<numbers.length; i++){
            int num = numbers[i];
            if(num == 1 || num == 4 || num == 7){
                left_location = num;
                sb.append("L");
            }else if(num == 3 || num == 6 || num == 9){
                right_location = num;
                sb.append("R");
            }else if(num == 2){
                if(two_dis[left_location] > two_dis[right_location]){
                    right_location = 2;
                    sb.append("R");
                }else if(two_dis[left_location] < two_dis[right_location]){
                    left_location = 2;
                    sb.append("L");
                }else{
                    if(hand.equals("right")){
                        right_location = 2;
                        sb.append("R");
                    }else{
                        left_location = 2;
                        sb.append("L");
                    }
                }
            }else if(num == 5){
                if(five_dis[left_location] > five_dis[right_location]){
                    right_location = 5;
                    sb.append("R");
                }else if(five_dis[left_location] < five_dis[right_location]){
                    left_location = 5;
                    sb.append("L");
                }else{
                    if(hand.equals("right")){
                        right_location = 5;
                        sb.append("R");
                    }else{
                        left_location = 5;
                        sb.append("L");
                    }
                }
            }else if(num == 8){
                if(eight_dis[left_location] > eight_dis[right_location]){
                    right_location = 8;
                    sb.append("R");
                }else if(eight_dis[left_location] < eight_dis[right_location]){
                    left_location = 8;
                    sb.append("L");
                }else{
                    if(hand.equals("right")){
                        right_location = 8;
                        sb.append("R");
                    }else{
                        left_location = 8;
                        sb.append("L");
                    }
                }
            }else if(num == 0){
                if(zero_dis[left_location] > zero_dis[right_location]){
                    right_location = 0;
                    sb.append("R");
                }else if(zero_dis[left_location] < zero_dis[right_location]){
                    left_location = 0;
                    sb.append("L");
                }else{
                    if(hand.equals("right")){
                        right_location = 0;
                        sb.append("R");
                    }else{
                        left_location = 0;
                        sb.append("L");
                    }
                }
            }
        }
        
        String answer = sb.toString();
        return answer;
    }
}