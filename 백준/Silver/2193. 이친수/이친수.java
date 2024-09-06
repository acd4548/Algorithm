import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1 || N == 2){
            System.out.print(1);
            return;
        }
        long [][] dp = new long [N+1][3];
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[1][2] = dp[1][0] + dp[1][1];
        dp[2][0] = 1;
        dp[2][1] = 0;
        dp[2][2] = dp[2][0] + dp[2][1];
        for(int i = 3; i<N+1; i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-1][0];
            dp[i][2] = dp[i][0] + dp[i][1];
        }
        System.out.print(dp[N][2]);
    }
}