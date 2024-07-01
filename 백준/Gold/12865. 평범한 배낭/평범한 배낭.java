import java.util.*;
import java.io.*;
public class Main {
    static int N, K, dp[][], arr[][];
    public static void main(String [] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int [N+1][2];
        for(int i = 1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int [N+1][K+1];

        System.out.print(dp(N, K));
    }

    static int dp(int i, int k){
        if(i < 0) return 0;

        if(dp[i][k] == 0){
            if(arr[i][0] > k){
                dp[i][k] = dp(i-1, k);
            }else{
                dp[i][k] = Math.max(dp(i-1, k), dp(i-1, k-arr[i][0]) + arr[i][1]);
            }
        }
        return dp[i][k];
    }
}