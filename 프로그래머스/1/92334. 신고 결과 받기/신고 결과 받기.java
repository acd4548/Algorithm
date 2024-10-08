import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int [] answer = new int [id_list.length];
        HashMap <String, Integer> m = new HashMap<>();
        for(int i = 0; i<id_list.length; i++){
            m.put(id_list[i], i);
        }
        //신고를 한번 돌면서 중복을 제거한다. Set
        Set <String> s = new HashSet<>();
        for(int i = 0; i<report.length; i++){
            s.add(report[i]);
        }
        
        //Set을 돌면서 신고 누가? 누구를 보고 2차원 배열로 [누가][누굴] 신고 기록
        //그리고 각 이름별 신고 누적수 기록.
        int [] be_reported = new int [id_list.length];
        int [][] info = new int [id_list.length][id_list.length];
        StringTokenizer st;
        Iterator<String> it = s.iterator();
        while(it.hasNext()){
            String str = it.next();
            st = new StringTokenizer(str);
            int nr = m.get(st.nextToken());
            int nc = m.get(st.nextToken());
            info[nr][nc] = 1;
            be_reported[nc]++;
        }
        
        //2차원 배열을 보고 답안 출력.
        for(int i = 0; i<id_list.length; i++){
            if(be_reported[i] >= k){
                for(int j = 0; j<id_list.length; j++){
                    if(info[j][i] == 1){
                        answer[j]++;
                    }
                }
            }
        }
        return answer;
    }
}