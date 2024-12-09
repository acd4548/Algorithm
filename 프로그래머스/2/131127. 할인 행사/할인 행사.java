import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        //want 는 원하는 제품
        //number은 각 제품의 개수
        //discount는 해당일 할인 품목
        //map에 want의 각 원소의 idx를 저장해주기
        //새로운 배열을 만들어 현재 각 want에 몇개씩 할인됬는지 저장해주기
        int answer = 0;
        
        int st = 0;
        int ed = 0;
        int [] cnt = new int [number.length];
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i<want.length; i++){
            map.put(want[i], i);
        }
        
        for(int i = 0; i<=discount.length - 10; i++){
            Arrays.fill(cnt, 0);
            for(int j = i; j<i + 10; j++){
                if(map.containsKey(discount[j])){
                    cnt[map.get(discount[j])]++;
                }
            }
            
            boolean flag = true;
            for(int j = 0; j<cnt.length; j++){
                if(cnt[j] != number[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
        }
        
        
        return answer;
    }
}