import java.util.*;
import java.io.*;

public class Main {

    static int N, K, can[], mae[][], lang[][];
    static long max, point;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    //입력받기
        N = Integer.parseInt(st.nextToken()); // 캔종류의 수
        K = Integer.parseInt(st.nextToken()); // 총 일 수
        can = new int [N];      //각 캔의 개수
        mae = new int[K][N];    //메리의 일자별 캔 선호도
        lang = new int[K][N];   //랑이의 일자별 캔 선호도
        max = Long.MIN_VALUE;
        point = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            can[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                lang[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                mae[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0);
        System.out.println(max);
    }

    private static void recur(int cur) {
        if(cur >= K){                   //일자를 다채우면 대소비교후 return;
            max = Math.max(point, max);
            return;
        }

        for(int i = 0; i<N; i++){       //캔종류돌아보면서 1개이상있다면
            if(can[i] > 0){             //mae 선호도 더하고 캔개수하나빼주기
                can[i]--;               
                point += mae[cur][i];
                for(int j = 0; j<N; j++){ // 이제 lang차례
                    if(can[j] > 0){
                        can[j]--;               //lang도 골랐으면
                        point += lang[cur][j];  //can하나뺴주고 lang더해주고
                        recur(cur+1);           //다음날 시작
                        can[j]++;               //다녀오면 원복
                        point -= lang[cur][j];
                    }
                }
                can[i]++;                       //다녀오면 원복
                point -= mae[cur][i];
            }
        }
    }
}