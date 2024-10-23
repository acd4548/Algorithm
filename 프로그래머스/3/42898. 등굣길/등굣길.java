import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int [][] cant_go = new int [n+1][m+1];
        for(int i = 0; i<puddles.length; i++){
            int [] temp = puddles[i];
            cant_go[temp[1]][temp[0]] = -1;
        }
        
        cant_go[1][1] = 1;
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<m+1; j++){
                if(i == 1 && j == 1) continue;
                if(cant_go[i][j] == -1) continue;
                
                int up = cant_go[i-1][j];
                int left = cant_go[i][j-1];
                
                if(up == -1 && left == -1){
                    continue;
                }else if(up == -1){
                    cant_go[i][j] = left % 1000000007;
                }else if(left == -1){
                    cant_go[i][j] = up % 1000000007;
                }else{
                    cant_go[i][j] = (up + left) % 1000000007;
                }
            }
        }
        
        answer = cant_go[n][m] % 1000000007;
        return answer;
    }
}