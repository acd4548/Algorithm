import java.util.*;
import java.io.*;
public class Main {
    static int N, M, max, min, sel[], check[];
    static String info[][];
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE; // 선택된 음악의 개수
        min = Integer.MAX_VALUE; // 선택된 기타의 개수
        sel = new int [N];
        info = new String [N][2];
        check = new int [M];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<2; j++){
                info[i][j] = st.nextToken();
            }
        }

        recur(0, 0, 0);
        if(max == 0){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }

    static void recur(int cur, int idx, int cnt){
        if(cur >= N){
            //cnt = 선택된 기타의 개수
            Arrays.fill(check, 0);
            for(int i = 0; i<idx; i++){
                for(int j = 0; j<M; j++){
                    if(info[sel[i]][1].charAt(j) == 'Y'){
                        check[j] = 1;
                    }
                }
            }
            int musicCnt = 0;
            for(int i = 0; i<M; i++){
                if(check[i] == 1){
                    musicCnt++;
                }
            }
            if(max < musicCnt){
                max = musicCnt;
                min = cnt;
            }else if(max == musicCnt){
                min = Math.min(cnt, min);
            }
            return;
        }
        sel[idx] = cur;
        recur(cur+1, idx+1, cnt+1);
        recur(cur+1, idx, cnt);
    }
}