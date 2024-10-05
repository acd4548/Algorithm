import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Queue<Integer> q = new LinkedList<>();
        int y = Integer.parseInt(today.substring(0, 4));
        int m = Integer.parseInt(today.substring(5, 7));
        int d = Integer.parseInt(today.substring(8, 10));
        
        Map <String, Integer> map = new HashMap<>();
        for(int i = 0; i<terms.length; i++){
            StringTokenizer st = new StringTokenizer(terms[i]);
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        for(int i = 0; i<privacies.length; i++){
            StringTokenizer st = new StringTokenizer(privacies[i]);
            String str = st.nextToken();
            int stY = Integer.parseInt(str.substring(0, 4));
            int stM = Integer.parseInt(str.substring(5, 7));
            int stD = Integer.parseInt(str.substring(8, 10));
            
            int terms_num = map.get(st.nextToken());
            
            stM += terms_num;
            if(stM % 12 == 0){
                stY += stM / 12 - 1;
                stM = 12;
            }else{
                stY += stM / 12;
                stM = stM % 12;
            }
            
            // 시작일 + 약정기간 <= 오늘 이면 queue에넣자
            if(y > stY){
                q.offer(i + 1);
                continue;
            }else if(y == stY){
                if(m > stM){
                    q.offer(i + 1);
                    continue;
                }else if(m == stM){
                    if(d >= stD){
                        q.offer(i + 1);
                        continue;
                    }
                }
            }
        }
        
        int temp = q.size();
        int [] arr = new int [temp];
        
        for(int i = 0; i<temp; i++){
            arr[i] = q.poll();
        }
        return arr;
    }
}