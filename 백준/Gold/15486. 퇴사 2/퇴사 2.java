import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int [][] info = new int [2][N+1];
        for(int i = 1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            info[0][i] = Integer.parseInt(st.nextToken());
            info[1][i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int [] dp = new int[N+2];
        int temp = 0;
        for(int i = 1; i<N+1; i++){
            if(i + info[0][i] - 1 <= N){
                if(dp[i] != 0){
                    temp = Math.max(temp, dp[i]);
                }

                int t = temp + info[1][i];
                if(t > dp[i + info[0][i]]){
                    dp[i + info[0][i]] = t;
                }
            }else{
                if(dp[i] != 0){
                    temp = Math.max(temp, dp[i]);
                }
            }
        }
        for(int i = 1; i<N+2; i++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }
}