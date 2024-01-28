import java.util.*;
import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int [1001];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }

        int prefix [] = new int [1005];
        int surfix [] = new int [1005];

        for(int i = 1; i<1001; i++){
            prefix[i] = Math.max(prefix[i-1], arr[i]);
        }

        for(int i = 1000; i>=1; i--){
            surfix[i] = Math.max(surfix[i+1], arr[i]);
        }

        int ans = 0;
        for(int i = 1; i<1001; i++){
            ans += Math.min(surfix[i], prefix[i]);
        }

        System.out.println(ans);
    }
}