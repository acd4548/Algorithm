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

        for(int i = 1; i<N+1; i++){
            for(int j = 1; j<K+1; j++){
                if(arr[i][0] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - arr[i][0]] + arr[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}