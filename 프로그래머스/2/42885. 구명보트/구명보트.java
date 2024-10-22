import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int [] visited = new int [people.length];
        Arrays.sort(people);
        int st = 0;
        int ed = people.length - 1;
        int temp_w = 0;
        while(st < ed){
            temp_w = people[ed];
            visited[ed--] = 1;
            if(people[st] + temp_w <= limit && visited[st] == 0){
                visited[st] = 1;
                temp_w += people[st];
                st++;
            }
            answer++;
        }
        
        if(st == ed && visited[st] == 0){
            answer++;
        }
        
        return answer;
    }
}