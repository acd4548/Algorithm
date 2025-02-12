import java.io.*;
import java.util.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int [] broken = new int [N+1];
        for(int i = 0; i<B; i++){
            int where = Integer.parseInt(br.readLine());
            broken[where] = 1;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i<=N - K + 1; i++){
            int cnt = 0;
            for(int j = i; j<i + K; j++){
                if(broken[j] == 1){
                    cnt++;
                }
            }
            ans = Math.min(ans, cnt);
        }
        System.out.println(ans);
    }
}