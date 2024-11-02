import java.util.*;
class Solution {
    static int max_len, len;
    static HashSet<Integer> s = new HashSet<>();
    static int [] visited;
    static StringBuilder sb;
    static String str;
    public int solution(String numbers) {
        int answer = 0;
        max_len = 0;
        len = numbers.length();
        str = numbers;
        
        for(int i = 0; i<len; i++){
            max_len = i + 1;
            visited = new int [len];
            sb = new StringBuilder();
            recur(0);
        }
        
        int [] arr = new int [10000010]; // 0이 소수 1이 소수아님
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i * i < 10000010; i++){
            if(arr[i] == 0){
                for(int j = i + i; j<10000010; j+=i){
                    arr[j] = 1;
                }
            }
        }
        
        for(int num : s){
            if(arr[num] == 0){
                answer++;
            }
        }
        
        return answer;
    }
    private static void recur(int cur){
        if(cur == max_len){
            String temp = sb.toString();
            s.add(Integer.parseInt(temp));
            return;
        }
        
        
        for(int i = 0; i<len; i++){
            if(visited[i] == 1) continue;
            
            visited[i] = 1;
            sb.append(str.charAt(i));
            recur(cur + 1);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = 0;
        }
    }
}