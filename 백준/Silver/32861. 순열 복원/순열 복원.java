import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean visited [] = new boolean [N + 1];
        int cnt [][] = new int [3][N];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 0) continue;
                else if(num == 1){
                    cnt[1][i]++;
                }else if(num == -1){
                    cnt[2][i]++;
                }
            }
            if(cnt[1][i] + cnt[2][i] == N - 1){
                cnt[0][i] = cnt[2][i] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            sb.append(cnt[0][i]).append(" ");
            if(!visited[cnt[0][i]]){
                visited[cnt[0][i]] = true;
            }else{
                System.out.println("-1");
                return;
            }
        }

        for(int i = 1; i<N+1; i++){
            if(!visited[i]){
                System.out.println("-1");
                return;
            }
        }
        System.out.println(sb);
    }
}