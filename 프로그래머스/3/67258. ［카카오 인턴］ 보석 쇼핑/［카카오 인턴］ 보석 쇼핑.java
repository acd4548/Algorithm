import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        HashSet<String> uniqueGems = new HashSet<>(Arrays.asList(gems));
        int gemKinds = uniqueGems.size();

        HashMap<String, Integer> gemIndexMap = new HashMap<>();
        int idx = 0;
        for (String gem : uniqueGems) {
            gemIndexMap.put(gem, idx++);
        }

        int[][] visited = new int[gemKinds][2]; // 각 보석의 빈도와 존재 여부
        int st = 0, ed = 0;
        int cnt = 0; // 포함된 고유 보석의 개수
        int minLength = Integer.MAX_VALUE; // 최소 길이

        while (ed < gems.length) {
            String gem = gems[ed];
            int gemIdx = gemIndexMap.get(gem);

            // 보석 추가 및 빈도 업데이트
            visited[gemIdx][1]++;
            if (visited[gemIdx][0] == 0) {
                visited[gemIdx][0] = 1;
                cnt++;
            }

            // 모든 보석을 포함했을 때 최단 구간을 찾아 업데이트
            while (cnt == gemKinds) {
                if (ed - st < minLength) {
                    minLength = ed - st;
                    answer[0] = st + 1;
                    answer[1] = ed + 1;
                }
                
                // 시작점의 보석 빈도를 줄이면서 구간 축소
                String startGem = gems[st];
                int startGemIdx = gemIndexMap.get(startGem);
                visited[startGemIdx][1]--;

                if (visited[startGemIdx][1] == 0) {
                    visited[startGemIdx][0] = 0;
                    cnt--;
                }
                st++;
            }
            ed++;
        }

        return answer;
    }
}
