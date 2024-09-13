import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long dp [][] = new long [2][10];
        for(int i = 1; i<10; i++){
            dp[0][i] = 1;
        }

        int cnt = 0;
        while(cnt != N){
            if(cnt % 2 != 0){
                for(int i = 0; i<10; i++){
                    dp[0][i] = 0;
                    if(i - 1 >= 0){
                        dp[0][i] += dp[1][i-1] % 1000000000;
                    }

                    if(i + 1 <= 9){
                        dp[0][i] += dp[1][i+1] % 1000000000;
                    }
                }
            }else{
                for(int i = 0; i<10; i++){
                    dp[1][i] = 0;
                    if(i - 1 >= 0){
                        dp[1][i] += dp[0][i-1] % 1000000000;
                    }

                    if(i + 1 <= 9){
                        dp[1][i] += dp[0][i+1] % 1000000000;
                    }
                }
            }
            cnt++;
        }

        long ans = 0;
        if(N % 2 == 0){
            for(int i = 0; i<10; i++){
                ans = (ans + dp[1][i]) % 1000000000;
            }
        }else{
            for(int i = 0; i<10; i++){
                ans = (ans + dp[0][i]) % 1000000000;
            }
        }
        System.out.print(ans);
    }
}