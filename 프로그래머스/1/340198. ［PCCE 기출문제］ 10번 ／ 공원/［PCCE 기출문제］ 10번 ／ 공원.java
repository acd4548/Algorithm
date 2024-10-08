import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        Arrays.sort(mats);
        
        outer1:
        for(int i = mats.length - 1; i>= 0; i--){
            int t = mats[i];
            
            int temp = t * t;
            for(int j = 0; j<=park.length - t; j++){
                for(int k = 0; k<=park[0].length - t; k++){
                    int cnt = 0;
                    
                    outer2:
                    for(int q = 0; q<t; q++){
                        for(int w = 0; w<t; w++){
                            if(park[j + q][k + w].equals("-1")){
                                cnt++;
                            }else{
                                break outer2;
                            }
                        }
                    }
                    
                    if(cnt == temp){
                        answer = t;
                        return t;
                    }
                }
            }
        }
        return -1;
    }
}