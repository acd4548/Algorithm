import java.util.*;
import java.io.*;

public class Main {
    static int N, info[][], minCost[], min, sel[], usedCost[];
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new int [N][5]; // 각 식재료별 영양성분과 가격
        minCost = new int [4]; // 최소 영양성분
        min = Integer.MAX_VALUE;
        sel = new int [N]; // 선택된 영양성분 ( idx )
        usedCost = new int [4]; // 선택된 영양성분들 각 몇씩인지 ( 최소"minCost"랑 비교할 애 )
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++){
            minCost[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5; j++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0);
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        System.out.println(min);
        while(!pq.isEmpty()){
            int num = pq.poll();
            sb.append(num).append(" ");
            a += info[num-1][0];
            b += info[num-1][1];
            c += info[num-1][2];
            d += info[num-1][3];
            if(a >= minCost[0] && b >= minCost[1] && c >= minCost[2] && d >= minCost[3]){
                break;
            }
        }
        System.out.println(sb);

    }

    static void recur(int cur, int idx){
        if(cur >= N){
            check(idx);
            return;
        }

        recur(cur+1, idx);
        sel[idx] = cur;
        recur(cur+1, idx+1);
    }

    private static void check(int idx){
        int selectedCost = 0;
        for(int i = 0; i<idx; i++){
            selectedCost += info[sel[i]][4];
        }
        if(selectedCost > min) return;

        int mp = 0;
        int mf = 0;
        int ms = 0;
        int mv = 0;
        for(int i = 0; i < idx; i++){
            mp += info[sel[i]][0];
            mf += info[sel[i]][1];
            ms += info[sel[i]][2];
            mv += info[sel[i]][3];
        }
        if(mp < minCost[0] || mf < minCost[1] || ms < minCost[2] || mv < minCost[3]) return;
        min = Math.min(min, selectedCost);
        pq.clear();
        for(int i = 0; i<idx; i++){
            pq.offer(sel[i]+1);
        }
        return;
    }
}