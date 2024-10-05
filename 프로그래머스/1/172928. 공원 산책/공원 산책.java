import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int [] where = {0, 0};
        char [][] map = new char [park.length][park[0].length()];
        for(int i = 0; i<park.length; i++){
            for(int j = 0; j<park[0].length(); j++){
                map[i][j] = park[i].charAt(j);
                if(map[i][j] == 'S'){
                    where[0] = i;
                    where[1] = j;
                }
            }
        }
        
        for(int i = 0; i<routes.length; i++){
            StringTokenizer st = new StringTokenizer(routes[i]);
            String way = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int temp [] = {where[0], where[1]};
            int flag = 1;
            
            if(way.equals("N")){
                while(cnt < dist){
                    cnt++;
                    temp[0] -= 1;
                    if(temp[0] < 0 || map[temp[0]][temp[1]] == 'X'){
                        flag = 0;
                        break;
                    }
                }
            }else if(way.equals("S")){
                while(cnt < dist){
                    cnt++;
                    temp[0] += 1;
                    if(temp[0] >= park.length || map[temp[0]][temp[1]] == 'X'){
                        flag = 0;
                        break;
                    }
                }
            }else if(way.equals("W")){
                while(cnt < dist){
                    cnt++;
                    temp[1] -= 1;
                    if(temp[1] < 0 || map[temp[0]][temp[1]] == 'X'){
                        flag = 0;
                        break;
                    }
                }
            }else if(way.equals("E")){
                while(cnt < dist){
                    cnt++;
                    temp[1] += 1;
                    if(temp[1] >= park[0].length() || map[temp[0]][temp[1]] == 'X'){
                        flag = 0;
                        break;
                    }
                }
            }
            
            if(flag == 1){
                where[0] = temp[0];
                where[1] = temp[1];
            }
        }
        
        
        return where;
    }
}