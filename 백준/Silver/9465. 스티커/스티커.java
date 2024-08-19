import java.util.*;
import java.io.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main (String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int arr[][], dp[][];
        for(int t = 0; t<tc; t++){
            int n = Integer.parseInt(br.readLine());
            arr = new int [2][n + 1];
            dp = new int [3][n + 1];
            for(int i = 0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j<n + 1; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 1; i<n + 1; i++){
                dp[0][i] = dp[1][i-1] + arr[0][i];
                dp[1][i] = dp[0][i-1] + arr[1][i];

                dp[0][i] = Math.max(dp[0][i], dp[2][i-1] + arr[0][i]);
                dp[1][i] = Math.max(dp[1][i], dp[2][i-1] + arr[1][i]);

                dp[2][i] = Math.max(dp[0][i-1], dp[1][i-1]);
            }

            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }
        System.out.print(sb);
    }
}