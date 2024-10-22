class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        //가로3 세로3이상임 무조건
        //최소가 brown 8 yellow 1
        for(int i = 1; i<=yellow; i++){
            int y_x = 0;
            int y_y = 0;
            int temp_b = 0;
            if(yellow % i == 0){
                y_x = yellow / i;
                y_y = i;
            }
            temp_b = (y_x * 2) + (y_y * 2) + 4;
            if(temp_b == brown && yellow == (y_x * y_y)){
                answer[0] = y_x + 2;
                answer[1] = y_y + 2;
                break;
            }
        }
        return answer;
    }
}