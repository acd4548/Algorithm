import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i<moves.length; i++){
            int location = moves[i] - 1;
            for(int j = 0; j<board.length; j++){
                if(board[j][location] != 0){
                    if(s.size() > 0 && s.peek() == board[j][location]){
                        answer += 2;
                        s.pop();
                    }else{
                        s.add(board[j][location]);
                    }
                    board[j][location] = 0;
                    
                    break;
                }
            }
        }
        
        for(int i = 0; i<board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }
        return answer;
    }
}