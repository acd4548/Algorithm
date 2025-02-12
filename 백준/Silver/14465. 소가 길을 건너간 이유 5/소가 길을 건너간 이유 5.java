import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int [] broke = new int [N+1];
        int [] prefix = new int [N+1];
        for(int i = 0; i<B; i++){
            int num = Integer.parseInt(br.readLine());
            broke[num] = 1;
        }

        for(int i = 1; i<N+1; i++){
            prefix[i] = prefix[i-1] + broke[i];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = K; i<N+1; i++){
            ans = Math.min(ans, prefix[i] - prefix[i-K]);
        }
        System.out.println(ans);
    }
}