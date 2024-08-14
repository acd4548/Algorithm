import java.util.*;
import java.io.*;

public class Main {
    static long a, b, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int [] arr = new int [N];
        int [] dp = new int [N];

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        Arrays.fill(dp, 1);
        int ans = 1;
        int max = -1;
        for(int i = 1; i<N; i++){
            max = -1;
            for(int j = i - 1; j>=0; j--){
                if(arr[i] > arr[j]){
                    max = Math.max(dp[j], max);
                    dp[i] = max + 1;
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        System.out.println(ans);
    }
}