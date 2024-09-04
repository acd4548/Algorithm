import java.util.*;
import java.io.*;

public class Main {
    static Integer[] dp;
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer [1000010];
        dp[0] = 1000;
        dp[1] = 1;
        cnt = 0;
        for(int i = 2; i<N+1; i++){
            if(i % 3 == 0 && i % 2 == 0){
                dp[i] = Math.min(dp[i/3], dp[i/2]);
                dp[i] = Math.min(dp[i], dp[i-1]) + 1;
            }else if(i % 3 == 0){
                dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
            }else if(i % 2 == 0){
                dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
            }else{
                dp[i] = dp[i-1] + 1;
            }
        }
        sb.append(N).append(" ");
        trace(N);


        System.out.println(cnt);
        System.out.print(sb);
    }

    static void trace(int cur){
        if(cur == 0 || cur == 1) return;
        cnt += 1;
        int min = dp[cur];
        int min_idx = 0;
        if(cur % 3 == 0 && cur % 2 == 0){
            if(min > dp[cur/3]){
                min_idx = cur/3;
            }

            if(min > dp[cur/2]){
                min_idx = cur/2;
            }

            if(min > dp[cur-1]){
                min_idx = cur - 1;
            }
        }else if(cur % 3 == 0){
            if(min > dp[cur/3]){
                min_idx = cur/3;
            }

            if(min > dp[cur-1]){
                min_idx = cur - 1;
            }
        }else if(cur % 2 == 0){
            if(min > dp[cur/2]){
                min_idx = cur/2;
            }

            if(min > dp[cur-1]){
                min_idx = cur - 1;
            }
        }else{
            if(min > dp[cur-1]){
                min_idx = cur - 1;
            }
        }
        if(min_idx == 0){
            sb.append(1).append(" ");
            return;
        }
        sb.append(min_idx).append(" ");
        trace(min_idx);
    }
}