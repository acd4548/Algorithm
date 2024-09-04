import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr [] = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int [] dp = new int [N];
        dp[0] = arr[0];
        int ans = dp[0];
        for(int i = 1; i<N; i++){
            int max = 0;
            for(int j = i; j>=0; j--){
                if(arr[i] > arr[j] && max < dp[j]){
                    max = dp[j];
                }
            }
            dp[i] = max + arr[i];
            ans = Math.max(dp[i], ans);
        }

        System.out.print(ans);
    }
}